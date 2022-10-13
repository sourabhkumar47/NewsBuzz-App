package com.example.newsbuzz.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsbuzz.domain.use_case.GetNewsArticleUseCase
import com.example.newsbuzz.presentation.HomeStateHolder
import com.example.newsbuzz.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val getNewsArticleUseCase: GetNewsArticleUseCase) :
    ViewModel() {

    val articles = mutableStateOf(HomeStateHolder())

    init {
        getNewsArticle()
    }

    fun getNewsArticle() {
        getNewsArticleUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    articles.value = HomeStateHolder(isLoading = true)
                }
                is Resource.Success -> {
                    articles.value = HomeStateHolder(data = it.data)
                }
                is Resource.Error -> {
                    articles.value = HomeStateHolder(error = it.message.toString())
                }
            }

        }.launchIn(viewModelScope)
    }
}