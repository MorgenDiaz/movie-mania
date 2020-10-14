package com.webslinger.portfolio.moviemania.data.repository.tvshow.datasource

import com.webslinger.portfolio.moviemania.data.networking.endpoints.TvShowService
import com.webslinger.portfolio.moviemania.data.networking.model.tvshow.NetworkTvShowsList
import com.webslinger.portfolio.moviemania.data.repository.tvshow.idatasource.ITvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSource(private val tvShowService: TvShowService, private val apiKey: String): ITvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<NetworkTvShowsList> = tvShowService.getPopular(apiKey)
}