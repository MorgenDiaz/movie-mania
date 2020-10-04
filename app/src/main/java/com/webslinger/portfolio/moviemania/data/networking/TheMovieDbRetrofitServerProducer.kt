package com.webslinger.portfolio.moviemania.data.networking

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class TheMovieDbRetrofitServerProducer {
    companion object{
        private const val BASE_URL = "https://api.themoviedb.org/3"

        fun produceNew(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }
    }
}