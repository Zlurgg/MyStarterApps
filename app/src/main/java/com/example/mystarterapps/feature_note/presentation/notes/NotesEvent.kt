package com.example.mystarterapps.feature_note.presentation.notes

import com.example.mystarterapps.feature_note.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: com.example.mystarterapps.feature_note.domain.model.Note): NotesEvent()
    data object RestoreNote: NotesEvent()
    data object ToggleOrderSection: NotesEvent()
}
