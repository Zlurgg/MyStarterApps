package com.example.mystarterapps.feature_room.presentation

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mystarterapps.feature_room.data.EntryApplication
import com.example.mystarterapps.feature_room.data.JournalEntry
import com.example.mystarterapps.core.util.DateUtil
import com.example.mystarterapps.feature_room.presentation.components.AddMoodCard
import com.example.mystarterapps.feature_room.presentation.components.AddNoteCard
import com.example.mystarterapps.feature_room.presentation.components.DisplayEntriesCard
import com.example.mystarterapps.feature_room.presentation.components.SaveCard
import kotlinx.coroutines.launch

@Composable
fun EntryScreen(
    //viewModelOld: EntryViewModel,
    navController: NavController,
    context: Context = LocalContext.current,
    entryViewModel: EntryViewModel = viewModel(
        factory = EntryViewModelFactory((context.applicationContext as EntryApplication).repository)
    ),
) {
    /** create view-model inside composable screen can be here or in the function variables above ^ **/
    /*    val context = LocalContext.current
        val entryViewModel = viewModel<EntryViewModel>(
            *//** own factory method allows for overriding create and adding variables (repos) **//*
    factory = EntryViewModelFactory((context.applicationContext as EntryApplication).repository)
)*/

    /** fetch all entries via the view-model **/
    val entries: List<JournalEntry> by entryViewModel.allEntries.observeAsState(listOf())
    val coroutineScope = rememberCoroutineScope()

    /** create an instance of entry details **/
    val entryDetails = entryViewModel.entriesUiState.entryDetails

    /** set current date for entry **/
    val date = DateUtil().getCurrentDate()
    entryDetails.date = date

    Column(verticalArrangement = Arrangement.SpaceBetween) {
        /** update entry with a mood **/
        Row {
            AddMoodCard(
                entryUiState = entryViewModel.entriesUiState,
                onEntryValueChange = entryViewModel::updateUiState,
                entryDetails = entryDetails
            )
        }

        /** update entry with a note **/
        Row {
            AddNoteCard(
                entryUiState = entryViewModel.entriesUiState,
                onEntryValueChange = entryViewModel::updateUiState,
                entryDetails = entryDetails
            )
        }

        /** save the entry **/
        Row {
            SaveCard(
                onSaveClick = {
                    coroutineScope.launch {
                        entryViewModel.saveEntry()
                    }
                }
            )
        }

        /** display all database entries **/
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            text = "Current database content:",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        Row(modifier = Modifier.padding(24.dp)) {
            LazyColumn(contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)) {
                items(
                    entries
                ) {
                    DisplayEntriesCard(journalEntry = it)
                }
            }
        }
    }
}



