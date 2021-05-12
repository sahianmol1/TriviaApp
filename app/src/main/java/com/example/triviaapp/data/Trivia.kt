package com.example.triviaapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat

@Parcelize
@Entity(tableName = "trivia_table")
data class Trivia(
    val name: String,
    val cricketerName: String,
    val flagColors: String,
    val dateTime: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true) val id: Int = 0
): Parcelable {
    val dateTimeFormatted: String
        get() = DateFormat.getDateTimeInstance().format(dateTime)
}
