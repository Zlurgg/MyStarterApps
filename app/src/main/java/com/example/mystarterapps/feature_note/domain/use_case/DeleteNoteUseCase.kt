package com.example.mystarterapps.feature_note.domain.use_case

import com.example.mystarterapps.feature_note.domain.model.Note
import com.example.mystarterapps.feature_note.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val repository: com.example.mystarterapps.feature_note.domain.repository.NoteRepository
) {
    suspend operator fun invoke(note: com.example.mystarterapps.feature_note.domain.model.Note) {
        repository.deleteNote(note)
    }
}