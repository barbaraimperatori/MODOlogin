package com.example.modologin.repository

import com.example.modologin.data.model.Login
import com.example.modologin.data.model.LoginResponse

interface LoginRepository {
    // corrutines
    suspend fun postLogin(login:Login): LoginResponse
}