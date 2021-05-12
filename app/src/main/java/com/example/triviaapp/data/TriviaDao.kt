package com.example.triviaapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TriviaDao {

    @Insert
    suspend fun insert(trivia: Trivia)

    @Query("SELECT * FROM trivia_table ORDER BY dateTime DESC")
    fun getAllTrivia(): Flow<List<Trivia>>
}