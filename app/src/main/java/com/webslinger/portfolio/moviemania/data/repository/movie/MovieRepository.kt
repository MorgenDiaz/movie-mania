package com.webslinger.portfolio.moviemania.data.repository.movie

import android.util.Log
import com.webslinger.portfolio.moviemania.data.datamapping.movie.IMovieListMapper
import com.webslinger.portfolio.moviemania.data.networking.model.movie.NetworkMovie
import com.webslinger.portfolio.moviemania.data.repository.movie.idatasource.IMovieCacheDataSource
import com.webslinger.portfolio.moviemania.data.repository.movie.idatasource.IMovieLocalDataSource
import com.webslinger.portfolio.moviemania.data.repository.movie.idatasource.IMovieRemoteDataSource
import com.webslinger.portfolio.moviemania.domain.model.Movie
import com.webslinger.portfolio.moviemania.domain.repository.IMovieRepository
import java.lang.Exception

class MovieRepository(
    private val remoteDataSource: IMovieRemoteDataSource,
    private val localDataSource: IMovieLocalDataSource,
    private val cacheDataSource: IMovieCacheDataSource,
    private val movieListMapper: IMovieListMapper
): IMovieRepository {
    override suspend fun getMovies(): List<Movie> {
        val cachedMovies = getMoviesFromCache()

        if(cachedMovies.isEmpty()){
            getMoviesFromDB().let {
                return if(it.isEmpty()){
                    getUpdatedMovies()
                }
                else{
                    cacheDataSource.updateMovies(it)
                    return it
                }
            }
        }

        return cachedMovies
    }

    override suspend fun getUpdatedMovies(): List<Movie> {
        downloadMoviesToDatabase()
        val movies = getMoviesFromDB()
        cacheDataSource.updateMovies(movies)
        return movies
    }

    private suspend fun downloadMoviesToDatabase() {
        val networkMovies = getMoviesFromNetwork()
        val dbMovies = movieListMapper.networkToDbModel(networkMovies)

        localDataSource.saveMovies(dbMovies)
    }

    private suspend fun getMoviesFromNetwork(): List<NetworkMovie>{
        var networkMovies: List<NetworkMovie> = listOf()

        try {
            val response = remoteDataSource.getMovies()
            val responseBody = response.body()

            responseBody?.let {
                networkMovies = it.networkMovies
            }
        }
        catch (e: Exception){
            Log.i("MovieMania", "Error downloading movies.")
        }

        return networkMovies
    }

    private suspend fun getMoviesFromDB(): List<Movie>{
        var movies: List<Movie> = listOf()
        try {
            val dbMovies = localDataSource.getMovies()
            movies = movieListMapper.dbToDomainModel(dbMovies)
        }
        catch (e: Exception){
            Log.i("MovieMania", "Error retrieving movies from database.")
        }

        return movies
    }

    private suspend fun getMoviesFromCache(): List<Movie>{
        return cacheDataSource.getMovies()
    }
}