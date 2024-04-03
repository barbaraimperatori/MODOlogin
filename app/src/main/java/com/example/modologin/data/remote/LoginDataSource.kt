package com.example.modologin.data.remote

import com.example.modologin.application.AppConstants
import com.example.modologin.data.model.Login
import com.example.modologin.repository.WebService

class LoginDataSource(private val webService: WebService) {

    suspend fun postLogin(): Login =  webService.postlogin(AppConstants.API_KEY)

}