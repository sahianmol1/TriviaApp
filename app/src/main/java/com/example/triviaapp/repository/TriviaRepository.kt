package com.example.triviaapp.repository

import com.example.triviaapp.data.Trivia
import com.example.triviaapp.data.TriviaDao
import javax.inject.Inject

class TriviaRepository @Inject constructor(private val triviaDao: TriviaDao) {

    suspend fun insert(trivia: Trivia) = triviaDao.insert(trivia)

    fun getAllTrivia() = triviaDao.getAllTrivia()
}