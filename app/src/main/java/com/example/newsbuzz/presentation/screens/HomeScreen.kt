package com.example.newsbuzz.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.newsbuzz.domain.model.Article
import com.example.newsbuzz.presentation.viewmodel.NewsViewModel

@Composable
fun HomeScreen(viewModel: NewsViewModel = hiltViewModel()) {

    val res = viewModel.articles.value


    if (res.isLoading) {
        Box(modifier = Modifier.fillMaxSize())
        {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (res.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = res.error,
                modifier = Modifier.align(Alignment.Center)
            )
        }

    }


    res.data?.let {
        LazyColumn {
            items(it) {
                ArticleItem(it)
            }
        }

    }


}

@Composable
fun ArticleItem(it: Article) {

    Column(
        modifier = Modifier
            .padding(34.dp)
    ) {

        Image(
            painter = rememberImagePainter(data = it.urlToImage),
            contentDescription = null,
            modifier = Modifier
                .height(208.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))

        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = it.title, style = TextStyle(
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
//            modifier = Modifier.padding(12.dp)
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = it.description,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 17.sp
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        it.publishedAt?.let { it1 ->
            Text(
                text = it.publishedAt,
                style = TextStyle(
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                )
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Button(onClick = { },
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Text(text = "Read")
            }

            Button(onClick = { },
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Text(text = "Save")
            }
        }

    }
}
