package com.example.testtask.presentation.converter

interface PresentationConverter<T, K>{
    fun convertTo(t: T): K
}