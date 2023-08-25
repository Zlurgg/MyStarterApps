package com.example.mystarterapps.feature_dagger_hilt_vm.presentation

import androidx.lifecycle.ViewModel
import com.example.mystarterapps.feature_dagger_hilt_vm.domain.repository.MyRepository
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: Lazy<MyRepository>
): ViewModel() {

    init {
        repository.get()
    }
}