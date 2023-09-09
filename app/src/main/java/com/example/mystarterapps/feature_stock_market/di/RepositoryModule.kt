package com.example.mystarterapps.feature_stock_market.di

import com.example.mystarterapps.feature_stock_market.data.csv.CompanyListingsParser
import com.example.mystarterapps.feature_stock_market.data.csv.CsvParser
import com.example.mystarterapps.feature_stock_market.data.csv.IntradayInfoParser
import com.example.mystarterapps.feature_stock_market.data.repository.StockRepositoryImpl
import com.example.mystarterapps.feature_stock_market.domain.model.CompanyListing
import com.example.mystarterapps.feature_stock_market.domain.model.IntradayInfo
import com.example.mystarterapps.feature_stock_market.domain.repository.StockRepository
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
    abstract fun bindCompanyListingParser(
        companyListingsParser: CompanyListingsParser
    ): CsvParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindIntradayInfoParser(
        intradayInfoParser: IntradayInfoParser
    ): CsvParser<IntradayInfo>


    @Binds
    @Singleton
    abstract fun bindStockRepository (
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}