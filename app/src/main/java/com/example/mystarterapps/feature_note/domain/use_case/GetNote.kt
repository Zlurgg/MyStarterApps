package com.example.mystarterapps.feature_note.domain.use_case

import com.example.mystarterapps.feature_note.domain.model.Note
import com.example.mystarterapps.feature_note.domain.repository.NoteRepository

class GetNote(
    private val repository: com.example.mystarterapps.feature_note.domain.repository.NoteRepository
) {
    suspend operator fun invoke(id: Int): com.example.mystarterapps.feature_note.domain.model.Note? {
        return repository.getNoteById(id)
    }
}