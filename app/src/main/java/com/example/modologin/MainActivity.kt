package com.example.modologin

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.modologin.core.Resource
import com.example.modologin.data.model.Login
import com.example.modologin.data.remote.LoginDataSource
import com.example.modologin.databinding.ActivityMainBinding
import com.example.modologin.presentation.LoginViewModel
import com.example.modologin.presentation.LoginViewModelFactory
import com.example.modologin.repository.LoginRepositoryImpl
import com.example.modologin.repository.RetroFitClient


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var password: String = ""

    private val viewModel by viewModels<LoginViewModel> {
        LoginViewModelFactory(
            LoginRepositoryImpl(
                LoginDataSource(
                    RetroFitClient.webService
                )
            )
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        setButtonClickListeners()

    }

    private fun setButtonClickListeners() {

        for (button in listOfButtons) {
            button.setOnClickListener {

                val buttonText = (it as Button).text.toString()

                password += buttonText

                if (password.length === 6) {

                    val login = Login(
                        dni = "37930877",
                        phone_number = "+5492477566569",
                        password = password
                    )

                    viewModel.postLogin(login).observe(this, Observer { resource ->
                        when (resource) {
                            is Resource.Loading -> {
                                Log.d("Loading state", "Loading")
                            }

                            is Resource.Success -> {
                                Log.d("Success state", "SUCCESS")
                            }

                            is Resource.Failure -> {
                                Log.d("Failure state", "FAILURE")
                            }
                        }
                    })
                }

            }
        }
    }


    private val listOfButtons = listOf(
        binding.key0,
        binding.key1,
        binding.key2,
        binding.key3,
        binding.key4,
        binding.key5,
        binding.key6,
        binding.key7,
        binding.key8,
        binding.key9,

        )

}