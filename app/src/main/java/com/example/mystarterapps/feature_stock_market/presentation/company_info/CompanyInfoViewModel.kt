package com.example.mystarterapps.feature_stock_market.presentation.company_info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystarterapps.feature_stock_market.common.util.Resource
import com.example.mystarterapps.feature_stock_market.domain.repository.StockRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyInfoViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: StockRepository
): ViewModel() {

    var state by mutableStateOf(CompanyInfoState())

    init {
        viewModelScope.launch {
            val symbol = savedStateHandle.get<String>("symbol") ?: return@launch
            println("CompanyInfoViewModel: symbol: ${symbol}")

            state = state.copy(isLoading = true)
            val companyInfoResult = async { repository.getCompanyInfo(symbol) }.await()
            println("CompanyInfoViewModel: companyInfoResult: ${companyInfoResult.data}")
            val intradayInfoResult = async { repository.getIntradayInfo(symbol) }.await()
            println("CompanyInfoViewModel: intradayInfoResult: ${intradayInfoResult.data}")

            when(val result = companyInfoResult) {
                is Resource.Success -> {
                    println("CompanyInfoViewModel: intradayInfoResult result: ${result.data}")
                    println("CompanyInfoViewModel: intradayInfoResult state: ${state}")

                    state = state.copy(
                        company = result.data,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        isLoading = false,
                        error = result.message,
                        company = null
                    )
                }
                else -> Unit
            }
            when(val result = intradayInfoResult) {
                is Resource.Success -> {
                    println("CompanyInfoViewModel: intradayInfoResult result: ${result.data}")
                    println("CompanyInfoViewModel: intradayInfoResult state: ${state}")

                    state = state.copy(
                        stockInfos = result.data ?: emptyList(),
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        isLoading = false,
                        error = result.message,
                        company = null
                    )
                }
                else -> Unit
            }
        }
    }
}
