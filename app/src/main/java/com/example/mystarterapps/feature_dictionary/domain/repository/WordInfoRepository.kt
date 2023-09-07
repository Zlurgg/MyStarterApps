package com.example.mystarterapps.feature_dictionary.domain.repository

import com.example.mystarterapps.common.util.Resource
import com.example.mystarterapps.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}