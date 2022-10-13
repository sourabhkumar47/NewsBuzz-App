package com.example.newsbuzz.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.newsbuzz.domain.model.Article
import com.example.newsbuzz.presentation.viewmodel.NewsViewModel

@Composable
fun HomeScreen(viewModel: NewsViewModel = hiltViewModel()) {
    val res = viewModel.articles.value

    if (res.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (res.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = res.error, modifier = Modifier.align(Alignment.Center))
        }
    }

    res.data?.let {
        LazyColumn {
            item(it) {
                ArticleItem(it)
            }
        }
    }
}

@Composable
fun ArticleItem(it: Article) {
    Column(modifier = Modifier) {

        Image(
            painter = rememberImagePainter(data = it.urlToImage),
            contentDescription = null,
            modifier = Modifier
                .height(300.dp)
                .fillMaxSize()
        )

        Text(
            text = it.title,
            style = TextStyle(fontWeight = FontWeight.SemiBold),
            modifier = Modifier.padding(12.dp)
        )

    }
}
