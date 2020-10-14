package com.webslinger.portfolio.moviemania.data.datamapping.movie

import com.webslinger.portfolio.moviemania.data.datamapping.common.IDataMapper
import com.webslinger.portfolio.moviemania.data.db.movie.DBMovie
import com.webslinger.portfolio.moviemania.data.networking.model.movie.NetworkMovie

interface IMovieNetworkToDbMapper: IDataMapper<NetworkMovie, DBMovie>