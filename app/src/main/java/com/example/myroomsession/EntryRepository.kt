package com.example.myroomsession

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class EntryRepository(private val entryDao: EntryDao) {

    val allEntries: Flow<List<Entry>> = entryDao.getEntriesOrderedByDate()

    fun getEntryFromDate(date: String): Entry = entryDao.getEntryFromDate(date)

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(entry: Entry) {
        entryDao.insert(entry)
    }

}