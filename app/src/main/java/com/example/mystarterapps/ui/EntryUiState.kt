package com.example.mystarterapps.ui

import com.example.mystarterapps.data.Entry

data class EntryUiState(
    val entryDetails: EntryDetails = EntryDetails(),
    val isEntryValid: Boolean = false
)

data class EntryDetails(
    var id: Int = 0,
    var date: String = "",
    var mood: String = "",
    var note: String = ""
)

fun EntryDetails.toEntry(): Entry = Entry(
    id = id,
    date = date,
    mood = mood,
    note = note
)
