package com.example.mystarterapps.feature_stock_market.data.mappers

import com.example.mystarterapps.feature_stock_market.data.local.CompanyListingEntity
import com.example.mystarterapps.feature_stock_market.data.remote.dto.CompanyInfoDto
import com.example.mystarterapps.feature_stock_market.domain.model.CompanyInfo
import com.example.mystarterapps.feature_stock_market.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = name ?: "",
        country = country ?: "",
        industry = industry ?: ""
    )
}