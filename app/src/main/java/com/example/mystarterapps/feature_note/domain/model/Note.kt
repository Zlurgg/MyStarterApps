package com.example.mystarterapps.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mystarterapps.feature_note.presentation.ui.theme.BabyBlue
import com.example.mystarterapps.feature_note.presentation.ui.theme.LightGreen
import com.example.mystarterapps.feature_note.presentation.ui.theme.RedOrange
import com.example.mystarterapps.feature_note.presentation.ui.theme.RedPink
import com.example.mystarterapps.feature_note.presentation.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, RedPink, BabyBlue)
    }
}

class InvalidNoteException(message: String): Exception(message)