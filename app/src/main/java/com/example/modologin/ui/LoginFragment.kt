package com.example.modologin.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.modologin.R
import com.example.modologin.databinding.ActivityMainBinding

class LoginFragment: Fragment(R.layout.activity_main)  {

    private lateinit var binding: ActivityMainBinding

    override fun onViewCreated( view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ActivityMainBinding.bind(view)
    }

}