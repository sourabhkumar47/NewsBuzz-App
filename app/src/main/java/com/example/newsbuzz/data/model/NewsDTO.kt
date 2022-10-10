package com.example.newsbuzz.data.model

data class NewsDTO(
    val articleDTOS: List<ArticleDTO>,
    val status: String,
    val totalResults: Int
)