package com.example.modologin.repository

import com.example.modologin.data.model.Login
import com.example.modologin.application.AppConstants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface WebService {

    @POST("login")
    suspend fun postlogin(@Query("api_key") apiKey: String): Login



}

object RetroFitClient {
    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}