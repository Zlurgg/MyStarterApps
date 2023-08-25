package com.example.mystarterapps.feature_dictionary.data.remote.dto

import com.example.mystarterapps.feature_dictionary.domain.model.Definition


data class DefinitionDto(
    val antonyms: List<Any>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
) {
    fun toDefinition(): Definition {
        return Definition(
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
    }
}