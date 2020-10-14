package com.webslinger.portfolio.moviemania.data.repository.tvshow

import android.util.Log
import com.webslinger.portfolio.moviemania.data.datamapping.tvshow.ITvShowListMapper
import com.webslinger.portfolio.moviemania.data.db.tvshow.DBTvShow
import com.webslinger.portfolio.moviemania.data.networking.model.tvshow.NetworkTVShow
import com.webslinger.portfolio.moviemania.data.repository.tvshow.idatasource.ITvShowCacheDataSource
import com.webslinger.portfolio.moviemania.data.repository.tvshow.idatasource.ITvShowLocalDataSource
import com.webslinger.portfolio.moviemania.data.repository.tvshow.idatasource.ITvShowRemoteDataSource
import com.webslinger.portfolio.moviemania.domain.TvShow
import com.webslinger.portfolio.moviemania.domain.repository.ITvShowRepository

class TvShowRepository(
    private val tvShowRemoteDataSource: ITvShowRemoteDataSource,
    private val tvShowLocalDataSource: ITvShowLocalDataSource,
    private val tvShowCacheDataSource: ITvShowCacheDataSource,
    private val tvShowListMapper: ITvShowListMapper
): ITvShowRepository{
    override suspend fun getTvShows(): List<TvShow> {
        val cachedTVShows = tvShowCacheDataSource.getTvShows()

        if(cachedTVShows.isEmpty()){
            val dbTvShows = getTvShowsFromDataBase()

            if(dbTvShows.isEmpty()){
                downloadTvShows()
                return tvShowCacheDataSource.getTvShows()
            }

        }

        return cachedTVShows
    }

    override suspend fun getUpdatedTvShows(): List<TvShow> {
        downloadTvShows()
        return tvShowCacheDataSource.getTvShows()
    }

    private suspend fun downloadTvShows(){
        val networkTvShows = getTvShowsFromNetwork()

        val dbTvShows = tvShowListMapper.networkToDbModel(networkTvShows)
        tvShowLocalDataSource.saveTvShows(dbTvShows)

        val tvShows = tvShowListMapper.dbToDomainModel(dbTvShows)
        tvShowCacheDataSource.updateTvShows(tvShows)
    }

    private suspend fun getTvShowsFromNetwork(): List<NetworkTVShow>{
        var networkTvShows: List<NetworkTVShow> = listOf()

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val responseBody = response.body()

            responseBody?.let {
                networkTvShows = it.networkTvShows
            }
        }
        catch (e: Exception){
            Log.i("MovieMania", "Error downloading tv shows from network.")
        }

        return networkTvShows
    }

    private suspend fun getTvShowsFromDataBase(): List<TvShow>{
        var tvShows: List<TvShow> = listOf()

        try {
            val dbTvShows: List<DBTvShow> = tvShowLocalDataSource.getTvShows()
            tvShows = tvShowListMapper.dbToDomainModel(dbTvShows)
        }
        catch (e: Exception){
            Log.i("MovieMania", "Error downloading tv shows from network.")
        }

        return tvShows
    }


}