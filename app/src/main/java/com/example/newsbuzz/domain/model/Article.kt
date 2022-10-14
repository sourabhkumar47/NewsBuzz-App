package com.example.newsbuzz.domain.model

import com.example.newsbuzz.data.model.SourceDTO

data class Article(

    val content: String,
    val description: String,
    val title: String,
    val publishedAt: String?,
    val urlToImage: String

)