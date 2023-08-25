package com.example.mystarterapps.feature_dagger_hilt_vm.data.repository

import android.app.Application
import com.example.mystarterapps.R
import com.example.mystarterapps.feature_dagger_hilt_vm.data.remote.MyApi
import com.example.mystarterapps.feature_dagger_hilt_vm.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: MyApi,
    private val appContext: Application
): MyRepository {

    init {
        val appName = appContext.getString(R.string.app_name)
        println("Hello from the repository. The app name is $appName")
    }

    override suspend fun doNetworkCall() {

    }
}