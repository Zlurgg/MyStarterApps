package com.example.mystarterapps.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mystarterapps.feature_note.domain.model.Note

@Database(
    entities = [com.example.mystarterapps.feature_note.domain.model.Note::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase() {
    abstract val noteDao: com.example.mystarterapps.feature_note.data.data_source.NoteDao

    companion object {
        const val DATABASE_NAME  = "notes_db"
    }
}