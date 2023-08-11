package com.example.myroomsession

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myroomsession.data.Entry
import com.example.myroomsession.data.EntryApplication
import com.example.myroomsession.data.EntryRepository
import kotlinx.coroutines.launch
import java.util.Calendar


@Composable
fun EntryScreen(
    //viewModelOld: EntryViewModel,
) {
    /** create view-model inside composable screen **/
    val context = LocalContext.current
    val entryViewModel = viewModel<EntryViewModel>(
        /** own factory method allows for overriding create and adding variables (repos) **/
        factory = EntryViewModelFactory((context.applicationContext as EntryApplication).repository)
    )

    /** fetch all entries from by view-model **/
    val entries: List<Entry> by entryViewModel.allEntries.observeAsState(listOf())
    val coroutineScope = rememberCoroutineScope()

    /** create an instance of entry details **/
    val entryDetails = entryViewModel.entriesUiState.entryDetails

    /** add date to the entry **/
    val date = getCurrentDate()
    entryDetails.date = date

    /** Next step implement navhost and make these different screens each with a different viewmodel that all update the entry (mood, note, date) **/
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
                    EntryCard(entry = it)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMoodCard(
    entryUiState: EntryUiState,
    onEntryValueChange: (EntryDetails) -> Unit,
    entryDetails: EntryDetails
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = "Today's Mood",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TextField(
                    value = entryUiState.entryDetails.mood,
                    onValueChange = { onEntryValueChange(entryDetails.copy(mood = it)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteCard(
    entryUiState: EntryUiState,
    onEntryValueChange: (EntryDetails) -> Unit,
    enabled: Boolean = true,
    entryDetails: EntryDetails
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = "Extra note about how you are feeling today?",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TextField(
                    value = entryUiState.entryDetails.note,
                    onValueChange = { onEntryValueChange(entryDetails.copy(note = it)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
                    modifier = Modifier.fillMaxWidth(),
                    enabled = enabled,
                    singleLine = true
                )
            }
        }
    }
}

@Composable
fun SaveCard(
    onSaveClick: () -> Unit,
    enabled: Boolean = true,
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = onSaveClick,
                enabled = enabled,
                shape = MaterialTheme.shapes.small,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Save")
            }
        }
    }
}


@Composable
fun EntryCard(entry: Entry) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
        ) {
            Text(
                text = entry.id.toString() + " | ",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                ),
            )
            Text(
                text = entry.date + " | ",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                )
            )
            Text(
                text = entry.mood + " | ",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                )
            )
            Text(
                text = entry.note,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                )
            )
        }
    }
}

private val c: Calendar = Calendar.getInstance()
fun getCurrentDate(): String {
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH) + 1
    val day = c.get(Calendar.DAY_OF_MONTH)
    return "$year-$month-$day"
}

