package com.example.pmagaamusicapp.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.pmagaamusicapp.components.MiniPlayer
import com.example.pmagaamusicapp.models.Album
import com.example.pmagaamusicapp.service.RetrofitInstance

@Composable
fun AlbumScreen(id: String) {
    var album by remember { mutableStateOf<Album?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(id) {
        try {
            album = RetrofitInstance.api.getAlbumDetail(id)
            isLoading = false
        } catch (e: Exception) {
            isLoading = false
            android.util.Log.e("API_ERROR",
                "Error en detalle: ${e.message}"
            )
        }
    }
    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else if (album != null) {
        val item = album!!
        Column(modifier = Modifier
            .fillMaxSize()
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
            ) {
                AsyncImage(
                    model = item.image,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray),
                    contentScale = ContentScale.Crop
                )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
                )
                Column(modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(20.dp)
                ) {
                    Text(text = item.title,
                        color = Color.White,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(text = item.artist,
                        color = Color.LightGray,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
            LazyColumn(modifier = Modifier
                .weight(1f)
                .padding(16.dp)
            ) {
                item {
                    Text(text = "Sobre el álbum",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(text = item.description,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier
                        .height(20.dp)
                    )
                    Text(text = "Canciones",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
                items(8) { index ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = item.image,
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.Gray),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = "Pista #${index + 1}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
            MiniPlayer(album = item)
        }
    }
}