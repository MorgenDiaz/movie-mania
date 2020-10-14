package com.webslinger.portfolio.moviemania.data.repository.movie.datamapping

import com.webslinger.portfolio.moviemania.data.datamapping.movie.IMovieListMapper
import com.webslinger.portfolio.moviemania.data.datamapping.movie.IMovieMapper
import com.webslinger.portfolio.moviemania.data.db.movie.DBMovie
import com.webslinger.portfolio.moviemania.data.networking.model.movie.NetworkMovie
import com.webslinger.portfolio.moviemania.domain.Movie

class MovieListMapper(
    private val movieMapper: IMovieMapper
): IMovieListMapper {
    override fun networkToDbModel(networkMovies: List<NetworkMovie>): List<DBMovie> {
        return networkMovies.map{
            movieMapper.networkToDbModel(it)
        }
    }

    override fun dbToDomainModel(dbMovies: List<DBMovie>): List<Movie> {
        return dbMovies.map {
            movieMapper.dbToDomainModel(it)
        }
    }
}