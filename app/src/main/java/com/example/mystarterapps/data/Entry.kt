package com.example.mystarterapps.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entries_table")
class Entry(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "mood") val mood: String,
    @ColumnInfo(name = "note") val note: String,
    @ColumnInfo(name = "date") val date: String
)
