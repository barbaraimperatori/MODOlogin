package com.example.modologin.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.modologin.core.Resource
import com.example.modologin.data.model.Login
import com.example.modologin.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class LoginViewModel(private val repository: LoginRepository): ViewModel( ) {

    fun postLogin(user: Login) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repository.postLogin(user)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}

class LoginViewModelFactory(private val repository: LoginRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(LoginRepository::class.java).newInstance(repository)
    }
}