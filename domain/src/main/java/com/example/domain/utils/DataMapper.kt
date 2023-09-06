package com.example.domain.utils

interface DataMapper<T> {
    fun toDomain(): T
}
