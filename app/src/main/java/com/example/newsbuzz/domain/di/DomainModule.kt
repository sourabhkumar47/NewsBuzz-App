package com.example.newsbuzz.domain.di

import com.example.newsbuzz.data.network.ApiService
import com.example.newsbuzz.data.repository.GetNewsArticleRepoImpl
import com.example.newsbuzz.domain.repository.GetNewsArticleRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideGetNewsRepo(apiService: ApiService):GetNewsArticleRepo{
        return GetNewsArticleRepoImpl(apiService = apiService)
    }
}