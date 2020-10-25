package com.webslinger.portfolio.moviemania.data.repository.movie.datamapping

import com.webslinger.portfolio.moviemania.data.datamapping.movie.IMovieDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.datamapping.movie.IMovieMapper
import com.webslinger.portfolio.moviemania.data.datamapping.movie.IMovieNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.db.movie.DBMovie
import com.webslinger.portfolio.moviemania.data.networking.model.movie.NetworkMovie
import com.webslinger.portfolio.moviemania.domain.model.Movie

class MovieMapper(
    private val networkToDbMapper: IMovieNetworkToDbMapper,
    private val dbToDomainMapper: IMovieDbToDomainMapper
    ): IMovieMapper {
    override fun networkToDbModel(networkMovie: NetworkMovie): DBMovie {
        return networkToDbMapper.map(networkMovie)
    }

    override fun dbToDomainModel(dbMovie: DBMovie): Movie {
        return dbToDomainMapper.map(dbMovie)
    }
}