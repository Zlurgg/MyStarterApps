package com.example.mystarterapps.feature_note.domain.repository

import com.example.mystarterapps.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNotes(): Flow<List<com.example.mystarterapps.feature_note.domain.model.Note>>

    suspend fun getNoteById(id: Int): com.example.mystarterapps.feature_note.domain.model.Note?

    suspend fun insertNote(note: com.example.mystarterapps.feature_note.domain.model.Note)

    suspend fun deleteNote(note: com.example.mystarterapps.feature_note.domain.model.Note)
}