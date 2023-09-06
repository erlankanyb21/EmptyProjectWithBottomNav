package com.example.data.di

import com.example.data.remote.repositories.ImageRepositoryImpl
import com.example.domain.repositories.ImagesRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.gson.gson
import io.ktor.serialization.kotlinx.json.json
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {

    singleOf(::createHttpClient)

    singleOf(::ImageRepositoryImpl) {
        bind<ImagesRepository>()
    }

}

private fun createHttpClient() = HttpClient(OkHttp) {
    install(Logging) {
        level = LogLevel.ALL
    }
    install(ContentNegotiation) {
        json()
    }
    engine {
        addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    }

}