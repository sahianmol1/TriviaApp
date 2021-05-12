package com.example.triviaapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.triviaapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_TriviaApp)
        setContentView(R.layout.activity_main)
    }
}