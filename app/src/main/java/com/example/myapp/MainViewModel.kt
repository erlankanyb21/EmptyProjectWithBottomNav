package com.example.myapp

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Test
import com.example.domain.useCase.FetchImageListUseCase
import com.example.myapp.base.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel(
    private val fetchImageListUseCase: FetchImageListUseCase
) : BaseViewModel() {

    val state:MutableState<List<Test>> = mutableStateOf(emptyList())

    init {
        viewModelScope.launch {
            val result = fetchImageListUseCase()
            state.value = result
        }
    }
}