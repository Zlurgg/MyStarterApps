package com.example.mystarterapps.feature_dagger_hilt_vm.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()
}