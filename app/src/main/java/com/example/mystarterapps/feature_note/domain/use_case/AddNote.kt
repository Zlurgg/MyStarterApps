package com.example.mystarterapps.feature_note.domain.use_case

import com.example.mystarterapps.feature_note.domain.model.InvalidNoteException
import com.example.mystarterapps.feature_note.domain.model.Note
import com.example.mystarterapps.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(
    private val repository: com.example.mystarterapps.feature_note.domain.repository.NoteRepository
) {

    @Throws(com.example.mystarterapps.feature_note.domain.model.InvalidNoteException::class)
    suspend operator fun invoke(note: com.example.mystarterapps.feature_note.domain.model.Note) {
        if (note.title.isBlank()) {
            throw com.example.mystarterapps.feature_note.domain.model.InvalidNoteException("The title of the note can't be empty.")
        }
        if (note.content.isBlank()) {
            throw com.example.mystarterapps.feature_note.domain.model.InvalidNoteException("The title of the content can't be empty.")
        }
        repository.insertNote(note)
    }
}