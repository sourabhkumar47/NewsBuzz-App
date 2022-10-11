package com.example.newsbuzz.data.model

data class NewsDTO(
    val article: List<ArticleDTO>?,
    val status: String?,
    val totalResults: Int?
)