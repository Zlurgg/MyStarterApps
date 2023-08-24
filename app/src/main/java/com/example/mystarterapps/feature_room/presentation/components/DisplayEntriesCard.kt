package com.example.mystarterapps.feature_room.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mystarterapps.feature_room.data.JournalEntry


@Composable
fun DisplayEntriesCard(journalEntry: JournalEntry) {
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
                text = journalEntry.id.toString() + " | ",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                ),
            )
            Text(
                text = journalEntry.date + " | ",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                )
            )
            Text(
                text = journalEntry.mood + " | ",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                )
            )
            Text(
                text = journalEntry.note,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                )
            )
        }
    }
}
