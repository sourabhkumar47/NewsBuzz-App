package com.example.newsbuzz.mapper

import com.example.newsbuzz.data.model.ArticleDTO
import com.example.newsbuzz.domain.model.Article

//map the objects
fun List<ArticleDTO>.toDomain():List<Article>{
    return map{
        Article(
            content = it.content?:"",
            description = it.description?:"",
            title = it.title?:"",
            urlToImage = it.urlToImage?:""
        )
    }
}