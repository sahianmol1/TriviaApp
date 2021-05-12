package com.example.triviaapp.ui.fragments.summary

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviaapp.data.Trivia
import com.example.triviaapp.repository.TriviaRepository
import kotlinx.coroutines.launch

class SummaryViewModel @ViewModelInject constructor(
    private val repository: TriviaRepository
) : ViewModel() {

    fun insert(trivia: Trivia) = viewModelScope.launch {
        repository.insert(trivia)
    }
}