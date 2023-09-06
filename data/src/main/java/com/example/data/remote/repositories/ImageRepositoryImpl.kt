package com.example.data.remote.repositories

import com.example.data.base.BaseRepository
import com.example.domain.models.Test
import com.example.domain.repositories.ImagesRepository
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.serialization.json.Json

class ImageRepositoryImpl(
    private val httpClient: HttpClient
) : ImagesRepository, BaseRepository() {
    override suspend fun fetchPagingImages(): Flow<List<Test>> {
        return try {

           val response = httpClient.get {
                url("https://fakestoreapi.com/products")
            }

            val images: List<Test> = Json.decodeFromString(response.toString())

            flowOf(images)

        } catch (e: Exception) {
            println(e.localizedMessage)
            emptyFlow()
        }
    }
}