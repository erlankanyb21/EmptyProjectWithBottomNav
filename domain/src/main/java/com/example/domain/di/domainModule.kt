package com.example.domain.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.example.domain.useCase.FetchImageListUseCase

val domainModule = module {
    
    factoryOf(::FetchImageListUseCase)
}