package com.example.newsbuzz.data.network

import com.example.newsbuzz.data.model.NewsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

//    https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=295a207929374e2ba1ffb86015ee1e7e

    @GET("top-headlines")
    suspend fun getNewsArticles(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey:String="295a207929374e2ba1ffb86015ee1e7e"
    ):Response<NewsDTO>
}