package com.example.newsbuzz.presentation

import com.example.newsbuzz.domain.model.Article

data class HomeStateHolder(
    val isLoading: Boolean = false,
    val data: List<Article>? = null,
    val error: String = ""
)
