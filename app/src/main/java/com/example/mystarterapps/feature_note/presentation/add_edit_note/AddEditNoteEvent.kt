package com.example.mystarterapps.feature_note.presentation.add_edit_note

import androidx.compose.ui.focus.FocusState
import java.time.LocalDate
import java.time.LocalDateTime

sealed class AddEditNoteEvent {
    data class EnteredTitle(val value: String): AddEditNoteEvent()
    data class ChangeTitleFocus(val focusState: FocusState): AddEditNoteEvent()
    data class EnteredDate(val date: LocalDateTime): AddEditNoteEvent()
    data class EnteredContent(val value: String): AddEditNoteEvent()
    data class ChangeContentFocus(val focusState: FocusState): AddEditNoteEvent()
    data class ChangeColor(val color: Int): AddEditNoteEvent()
    data object SaveNote: AddEditNoteEvent()
}
