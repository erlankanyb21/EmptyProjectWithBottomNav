package com.example.domain.useCase

import com.example.domain.repositories.ImagesRepository

class FetchImageListUseCase(
    private val imagesRepository: ImagesRepository
) {
    suspend operator fun invoke() = imagesRepository.fetchPagingImages()
}