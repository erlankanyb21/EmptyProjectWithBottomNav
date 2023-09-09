package com.example.data.remote.repositories

import com.example.data.base.BaseRepository
import com.example.domain.models.Test
import com.example.domain.repositories.ImagesRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class ImageRepositoryImpl(
    private val httpClient: HttpClient
) : ImagesRepository, BaseRepository() {

    override suspend fun fetchPagingImages(): List<Test> {
        return try {
            httpClient.get {
                url("https://fakestoreapi.com/products")
            }.body()
        } catch (e:Exception){
            e.printStackTrace()
            emptyList()
        }
    }
}