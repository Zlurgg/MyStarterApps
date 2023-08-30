package com.example.mystarterapps.feature_note.data.repository

import com.example.mystarterapps.feature_note.data.data_source.NoteDao
import com.example.mystarterapps.feature_note.domain.model.Note
import com.example.mystarterapps.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: com.example.mystarterapps.feature_note.data.data_source.NoteDao
): com.example.mystarterapps.feature_note.domain.repository.NoteRepository {
    override fun getNotes(): Flow<List<com.example.mystarterapps.feature_note.domain.model.Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): com.example.mystarterapps.feature_note.domain.model.Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: com.example.mystarterapps.feature_note.domain.model.Note) {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(note: com.example.mystarterapps.feature_note.domain.model.Note) {
        return dao.deleteNote(note)
    }
}