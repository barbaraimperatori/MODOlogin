package com.example.modologin

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.os.Bundle
import com.example.modologin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setButtonClickListeners()
    }

    private fun setButtonClickListeners() {
        // Iterate through the list of buttons and set click listeners
        for (button in listOfButtons) {
            button.setOnClickListener {
                // Get the text of the clicked button
                val buttonText = (it as Button).text.toString()

                // Append the clicked key to the password
                password += buttonText

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