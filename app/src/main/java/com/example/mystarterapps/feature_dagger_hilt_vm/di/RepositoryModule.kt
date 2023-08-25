package com.example.mystarterapps.feature_dagger_hilt_vm.di

import com.example.mystarterapps.feature_dagger_hilt_vm.data.repository.MyRepositoryImpl
import com.example.mystarterapps.feature_dagger_hilt_vm.domain.repository.MyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMyRepository(
        myRepositoryImpl: MyRepositoryImpl
    ): MyRepository
}