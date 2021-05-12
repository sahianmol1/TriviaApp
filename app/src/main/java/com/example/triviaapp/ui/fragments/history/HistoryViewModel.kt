package com.example.triviaapp.ui.fragments.history

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.triviaapp.repository.TriviaRepository

class HistoryViewModel @ViewModelInject constructor(
    private val repository: TriviaRepository
): ViewModel() {
    fun getAllTrivia() = repository.getAllTrivia().asLiveData()
}