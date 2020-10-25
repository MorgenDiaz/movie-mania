package com.webslinger.portfolio.moviemania.data.networking.endpoints

import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkActorDetails
import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkActorList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ActorService {
    @GET("person/popular")
    suspend fun getPopular(@Query("api_key") apiKey: String): Response<NetworkActorList>

    @GET("person/{person_id}")
    suspend fun getDetails(@Path("person_id") personId: Int, @Query("api_key") apiKey: String): Response<NetworkActorDetails>
}