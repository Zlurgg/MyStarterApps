package com.example.mystarterapps.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mystarterapps.feature_dictionary.domain.model.Meaning
import com.example.mystarterapps.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String,
    val origin: String,
    // should be another table for meanings as its a list (in this case directly saving via converting to a string
    val meanings: List<Meaning>,
    @PrimaryKey val id: Int? = null
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings, origin, phonetic, word
        )
    }
}
