package com.example.loginvalidation.network

import com.example.loginvalidation.models.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    suspend fun getDataFromApi(@Query("g")query : String): RecyclerList

}