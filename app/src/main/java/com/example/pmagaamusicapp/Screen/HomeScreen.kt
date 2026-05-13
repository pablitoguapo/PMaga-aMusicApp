package com.example.pmagaamusicapp.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pmagaamusicapp.components.*
import com.example.pmagaamusicapp.models.Album
import com.example.pmagaamusicapp.service.RetrofitInstance
import com.example.pmagaamusicapp.ui.theme.PMagañaMusicAppTheme

@Composable
fun HomeScreen(
    innerPadding: PaddingValues,
    navController: NavController
) {

    var albums by remember {
        mutableStateOf(listOf<Album>())
    }
    var isLoading by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(Unit) {
        try {
            val response = RetrofitInstance.api.getAlbums()
            android.util.Log.d("API_SUCCESS", "Álbumes recibidos: ${response.size}")
            albums = response
            isLoading = false
        } catch (e: Exception) {
            isLoading = false
            // ESTO TE DIRÁ EL ERROR REAL EN LOGCAT (ej. Problemas de conexión, JSON mal formado, etc.)
            android.util.Log.e("API_ERROR", "Error al obtener álbumes: ${e.message}", e)
        }
    }
    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(0xFF8B5CF6),
                            Color(0xFFF5F5F5)
                        )
                    )
                )
                .padding(innerPadding)
                .padding(18.dp)
        ) {
            Text(
                text = "Good Morning!",
                color = Color.White
            )
            Text(
                text = "Pablo Eduardo",
                color = Color.White
            )

            Text(text = "Albums",
                modifier = Modifier.padding(bottom = 10.dp, top = 20.dp)
                )

            LazyRow {
                items(albums) { album ->
                    AlbumCard(
                        album = album,
                        onClick = {
                            navController.navigate(
                                "detail/${album.id}"
                            )
                        }
                    )
                }
            }

            Text(text = "Recently Played",
                modifier = Modifier.padding(bottom = 10.dp, top = 20.dp)
            )

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(albums) { album ->
                    RecentItem(
                        album = album,
                        onClick = {
                            navController.navigate(
                                "detail/${album.id}"
                            )
                        }
                    )
                }
            }
            MiniPlayer(
                album = albums.firstOrNull()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    PMagañaMusicAppTheme {
        HomeScreen(
            innerPadding = PaddingValues(),
            navController = NavController(LocalContext.current)
        )
    }
}