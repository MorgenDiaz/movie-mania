package com.webslinger.portfolio.moviemania.data.repository.tvshow.idatasource

import com.webslinger.portfolio.moviemania.data.networking.model.tvshow.NetworkTvShowsList
import retrofit2.Response

interface ITvShowRemoteDataSource {
    suspend fun getTvShows(): Response<NetworkTvShowsList>
}
