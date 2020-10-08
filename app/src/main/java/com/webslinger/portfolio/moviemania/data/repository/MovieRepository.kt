package com.webslinger.portfolio.moviemania.data.repository

import android.util.Log
import com.webslinger.portfolio.moviemania.data.dto.movie.IMovieDTO
import com.webslinger.portfolio.moviemania.data.networking.schema.movie.MovieSchema
import com.webslinger.portfolio.moviemania.domain.Movie
import com.webslinger.portfolio.moviemania.domain.repository.IMovieRepository
import java.lang.Exception

class MovieRepository(
    private val remoteDataSource: IMovieRemoteDataSource,
    private val localDataSource: IMovieLocalDataSource,
    private val cacheDataSource: IMovieCacheDataSource,
    private val movieDTO: IMovieDTO
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
        val dbMovies = networkMovies.map {
            movieDTO.schemaToDBModel(it)
        }

        localDataSource.saveMovies(dbMovies)
    }

    private suspend fun getMoviesFromNetwork(): List<MovieSchema>{
        var movies: List<MovieSchema> = listOf()

        try {
            val response = remoteDataSource.getMovies()
            val responseBody = response.body()

            responseBody?.let {
                movies = it.movieSchemas
            }
        }
        catch (e: Exception){
            Log.i("MovieMania", "Error downloading movies.")
        }

        return movies
    }

    private suspend fun getMoviesFromDB(): List<Movie>{
        var movies: List<Movie> = listOf()
        try {
            val dbMovies = localDataSource.getMovies()
            movies = dbMovies.map {
                movieDTO.dbModelToDomain(it)
            }
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