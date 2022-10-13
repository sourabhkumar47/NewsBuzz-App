package com.example.newsbuzz.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.newsbuzz.domain.use_case.GetNewsArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val getNewsArticleUseCase: GetNewsArticleUseCase) :
    ViewModel() {
    
        val articles = mutableSetOf()
}