package com.example.mystarterapps.feature_dictionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mystarterapps.feature_dictionary.presentation.WordInfoItem
import com.example.mystarterapps.feature_dictionary.presentation.WordInfoViewModel
import com.example.mystarterapps.ui.theme.MyStarterAppsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyStarterAppsTheme {
                val viewModel: WordInfoViewModel = hiltViewModel()
                val state = viewModel.state.value
                val snackbarHostState = remember { SnackbarHostState() }

                LaunchedEffect(key1 = true) {
                    viewModel.eventFlow.collectLatest { event ->
                        when (event) {
                            is WordInfoViewModel.UIEvent.ShowSnackbar -> {
                                snackbarHostState.showSnackbar(
                                    message = event.message
                                )
                            }
                        }
                    }
                }
                Scaffold(
                    snackbarHost = { SnackbarHost(snackbarHostState) },
                    content = { padding ->
                        Box(
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.background)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp)
                            ) {
                                TextField(
                                    value = viewModel.searchQuery.value,
                                    onValueChange = viewModel::onSearch,
                                    modifier = Modifier.fillMaxWidth(),
                                    placeholder = {
                                        Text(text = "Search...")
                                    }
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                LazyColumn(
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    items(state.wordInfoItems.size) { i ->
                                        val wordInfo = state.wordInfoItems[i]
                                        if(i > 0) {
                                            Spacer(modifier = Modifier.height(8.dp))
                                        }
                                        WordInfoItem(wordInfo = wordInfo)
                                        if(i < state.wordInfoItems.size - 1) {
                                            Divider()
                                        }
                                    }
                                }
                            }
                            if(state.isLoading) {
                                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                            }

                        }

                    }
                )
            }
        }
    }
}


