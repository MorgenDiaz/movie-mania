package com.webslinger.portfolio.moviemania.data.datamapping.movie

import com.webslinger.portfolio.moviemania.data.datamapping.common.IListDataMapper
import com.webslinger.portfolio.moviemania.data.db.movie.DBMovie
import com.webslinger.portfolio.moviemania.data.networking.model.movie.NetworkMovie
import com.webslinger.portfolio.moviemania.domain.Movie

interface IMovieListMapper {
    fun networkToDbModel(networkMovies: List<NetworkMovie>): List<DBMovie>
    fun dbToDomainModel(dbMovies: List<DBMovie>): List<Movie>
}