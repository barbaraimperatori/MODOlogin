package com.example.modologin.data.remote

import com.example.modologin.application.AppConstants
import com.example.modologin.data.model.Login
import com.example.modologin.data.model.LoginResponse
import com.example.modologin.repository.WebService

class LoginDataSource(private val webService: WebService) {

    suspend fun postLogin(login: Login): LoginResponse =  webService.postLogin(body = login)

}