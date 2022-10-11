package com.example.newsbuzz.data.repository

import com.example.newsbuzz.data.network.ApiService
import com.example.newsbuzz.domain.model.Article
import com.example.newsbuzz.domain.repository.GetNewsArticleRepo
import com.example.newsbuzz.mapper.toDomain
import com.example.newsbuzz.utils.SafeApiRequest
import javax.inject.Inject

class GetNewsArticleRepoImpl @Inject constructor(private val apiService: ApiService) :
    GetNewsArticleRepo , SafeApiRequest(){
    override suspend fun getNewsArticle(): List<Article> {
        val response = safeApiRequest { apiService.getNewsArticles() }
        return response?.article?.toDomain()!!
    }
}