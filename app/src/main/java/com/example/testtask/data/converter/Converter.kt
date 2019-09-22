package com.example.testtask.data.converter

interface Converter<T, K>{
    fun convertTo(t: T): K
}