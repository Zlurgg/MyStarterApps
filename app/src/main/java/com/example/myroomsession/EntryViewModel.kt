package com.example.myroomsession

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

private const val TAG = "EntryViewModel"

class EntryViewModel(val entryRepository: EntryRepository): ViewModel() {

    var entriesUiState by mutableStateOf(EntryUiState())
        private set

    fun updateUiState(entryDetails: EntryDetails) {
        entriesUiState =
            EntryUiState(entryDetails = entryDetails, isEntryValid = validateInput(entryDetails))
    }

    val allEntries: LiveData<List<Entry>> = entryRepository.allEntries.asLiveData()

    fun insert(entry: Entry) = viewModelScope.launch {
        entryRepository.insert(entry)
    }

    private fun validateInput(uiState: EntryDetails = entriesUiState.entryDetails): Boolean {
        return with(uiState) {
            date.isNotBlank() && mood.isNotBlank()
        }
    }

    suspend fun saveEntry() {
        if (validateInput()) {
            entryRepository.insert(entriesUiState.entryDetails.toEntry())
        } else {
            Log.i(TAG, "Input not valid: " + entriesUiState.entryDetails);
        }
    }

    fun entryFromDate(date: String) = viewModelScope.launch {
        entryRepository.getEntryFromDate(date)
    }


}

class EntryViewModelFactory(private val repository: EntryRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EntryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EntryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


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
