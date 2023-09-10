package com.example.mystarterapps.feature_stock_market.domain.repository

import com.example.mystarterapps.feature_stock_market.common.util.Resource
import com.example.mystarterapps.feature_stock_market.domain.model.CompanyInfo
import com.example.mystarterapps.feature_stock_market.domain.model.CompanyListing
import com.example.mystarterapps.feature_stock_market.domain.model.IntradayInfo
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>

    suspend fun getIntradayInfo(
        symbol: String
    ): Resource<List<IntradayInfo>>

    suspend fun getCompanyInfo(
        symbol: String
    ): Resource<CompanyInfo>
}