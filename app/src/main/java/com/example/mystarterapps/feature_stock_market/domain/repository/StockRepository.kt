package com.example.mystarterapps.feature_stock_market.domain.repository

import com.example.mystarterapps.feature_stock_market.common.util.Resource
import com.example.mystarterapps.feature_stock_market.domain.model.CompanyListing
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>
}