package com.webslinger.portfolio.moviemania.data.networking.endpoints

import com.webslinger.portfolio.moviemania.data.networking.schema.character.CharacterSchema
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {
    @GET("/person/popular")
    suspend fun getPopular(@Query("api_key") apiKey: String): Response<CharacterSchema>
}