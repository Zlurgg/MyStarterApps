package com.example.mystarterapps.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mystarterapps.feature_note.ui.theme.BabyBlue
import com.example.mystarterapps.feature_note.ui.theme.LightGreen
import com.example.mystarterapps.feature_note.ui.theme.RedOrange
import com.example.mystarterapps.feature_note.ui.theme.RedPink
import com.example.mystarterapps.feature_note.ui.theme.Violet
import java.time.LocalDate

@Entity
data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val dateStamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, RedPink, BabyBlue)
    }
}

class InvalidNoteException(message: String): Exception(message)