package com.example.newsbuzz.data.model

data class NewsDTO(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)