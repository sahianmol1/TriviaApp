package com.example.triviaapp.di

import android.content.Context
import androidx.room.Room
import com.example.triviaapp.data.TriviaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTriviaDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, TriviaDatabase::class.java, "trivia_database")
            .build()

    @Provides
    @Singleton
    fun provideTriviaDao(triviaDatabase: TriviaDatabase) = triviaDatabase.getTriviaDao()
}