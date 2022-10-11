package com.example.newsbuzz.data.repository

import com.example.newsbuzz.data.network.ApiService
import com.example.newsbuzz.domain.repository.GetNewsArticleRepo
import javax.inject.Inject

class GetNewsArticleRepoImpl @Inject constructor(private val apiService: ApiService) :
    GetNewsArticleRepo {
}