package com.example.myroomsession

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface EntryDao {

    @Query("SELECT * FROM entries_table WHERE date = :date")
    fun getEntryFromDate(date: String): Entry

    @Query("SELECT * FROM entries_table ORDER BY date ASC")
    fun getEntriesOrderedByDate(): Flow<List<Entry>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entry: Entry)

    @Query("DELETE FROM entries_table")
    suspend fun deleteAll()
}