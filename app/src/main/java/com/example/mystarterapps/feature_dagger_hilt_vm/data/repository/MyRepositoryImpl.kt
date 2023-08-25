package com.example.mystarterapps.feature_dagger_hilt_vm.data.repository

import com.example.mystarterapps.feature_dagger_hilt_vm.data.remote.MyApiDummy
import com.example.mystarterapps.feature_dagger_hilt_vm.domain.repository.MyRepository

class MyRepositoryImpl(
    private val api: MyApiDummy
): MyRepository {

    override suspend fun doNetworkCall() {

    }
}