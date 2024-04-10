package com.example.modologin.repository

import com.example.modologin.data.model.Login
import com.example.modologin.application.AppConstants
import com.example.modologin.data.model.LoginResponse
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface WebService {

    @Headers( "x-fingerprint: ${AppConstants.FINGERPRINT_HEADER}")
    @POST("/v2/auth/login")
    suspend fun postLogin(@Body body: Login) : LoginResponse

}

object RetroFitClient {

    private val interceptorLogs = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY

    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptorLogs)
        .build()

    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}