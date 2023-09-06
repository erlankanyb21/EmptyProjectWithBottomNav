package com.example.data.remote.services

import com.example.domain.models.Test
import kotlinx.coroutines.flow.Flow

interface ApiService {
    suspend fun fetchPagingImages(
    ) : Flow<List<Test>>
}