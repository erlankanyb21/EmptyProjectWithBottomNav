package com.example.myapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.remote.services.ApiService
import com.example.domain.useCase.FetchImageListUseCase
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainViewModel(
    private val fetchImageListUseCase: FetchImageListUseCase
) : ViewModel() {

}