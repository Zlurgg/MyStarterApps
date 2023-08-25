package com.example.mystarterapps.feature_dagger_hilt_vm.data.remote

import retrofit2.http.GET

interface MyApi {

    @GET("test")
    suspend fun doNetworkCall()
}