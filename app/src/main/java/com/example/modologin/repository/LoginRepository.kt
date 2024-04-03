package com.example.modologin.repository

import com.example.modologin.data.model.Login

interface LoginRepository {
    // corrutines
    suspend fun postLogin(): Login
}