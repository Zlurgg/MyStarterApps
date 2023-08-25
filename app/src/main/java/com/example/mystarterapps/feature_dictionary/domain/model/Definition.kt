package com.example.mystarterapps.feature_dictionary.domain.model

data class Definition(
    val antonyms: List<Any>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
)
