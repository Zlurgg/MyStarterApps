package com.example.mystarterapps.feature_stock_market

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mystarterapps.feature_stock_market.presentation.NavGraphs
import com.example.mystarterapps.feature_stock_market.ui.theme.StockMarketAppTheme
import com.ramcosta.composedestinations.DestinationsNavHost

@Composable
fun StockMarketApp() {
    StockMarketAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DestinationsNavHost(navGraph = NavGraphs.root)
        }
    }
}