package com.example.myroomsession

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class EntryApplication: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { EntryRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { EntryRepository(database.entryDao()) }
}