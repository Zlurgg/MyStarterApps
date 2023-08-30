package com.example.mystarterapps.feature_note.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mystarterapps.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<com.example.mystarterapps.feature_note.domain.model.Note>>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int): com.example.mystarterapps.feature_note.domain.model.Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: com.example.mystarterapps.feature_note.domain.model.Note)

    @Delete
    suspend fun deleteNote(note: com.example.mystarterapps.feature_note.domain.model.Note)
}