package com.webslinger.portfolio.moviemania.data.datamapping.movie

import com.webslinger.portfolio.moviemania.data.db.movie.DBMovie
import com.webslinger.portfolio.moviemania.data.networking.model.movie.NetworkMovie
import com.webslinger.portfolio.moviemania.domain.Movie

interface IMovieMapper {
    fun networkToDbModel(networkMovie: NetworkMovie): DBMovie
    fun dbToDomainModel(dbMovie: DBMovie): Movie
}