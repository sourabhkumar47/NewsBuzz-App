package com.example.newsbuzz.domain.repository

import com.example.newsbuzz.domain.model.Article

interface GetNewsArticleRepo {
    suspend fun getNewsArticle(): List<Article>
}