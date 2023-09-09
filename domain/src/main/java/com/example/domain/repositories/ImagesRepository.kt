package com.example.domain.repositories

import com.example.domain.models.Test
import kotlinx.coroutines.flow.Flow

interface ImagesRepository {

  suspend fun fetchPagingImages(
  ) : List<Test>

}