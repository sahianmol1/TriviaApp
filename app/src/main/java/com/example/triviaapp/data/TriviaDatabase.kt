package com.example.triviaapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Trivia::class], version = 1)
abstract class TriviaDatabase: RoomDatabase() {
    abstract fun getTriviaDao(): TriviaDao
}