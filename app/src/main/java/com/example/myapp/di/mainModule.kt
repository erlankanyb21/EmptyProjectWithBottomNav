package com.example.myapp.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.example.myapp.MainViewModel

val mainModule = module {
    viewModelOf(::MainViewModel)
}