package com.example.modologin.repository

import com.example.modologin.data.model.Login
import com.example.modologin.data.remote.LoginDataSource

class LoginRepositoryImpl(private val dataSource: LoginDataSource): LoginRepository {
    override suspend fun postLogin(): Login = dataSource.postLogin()
}