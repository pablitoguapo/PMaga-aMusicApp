package com.example.pmagaamusicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.pmagaamusicapp.models.Album
import com.example.pmagaamusicapp.ui.theme.PMagañaMusicAppTheme

@Composable
fun AlbumCard(
    album: Album,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .padding(end = 12.dp)
            .width(170.dp)
            .height(210.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                onClick()
            }
    ) {

        AsyncImage(
            model = album.image, // Usamos la URL directa de la API
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x66000000))
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(12.dp)
        ) {

            Text(
                text = album.title,
                color = Color.White
            )

            Text(
                text = album.artist,
                color = Color.LightGray
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp)
                .size(40.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAlbumCard() {
    PMagañaMusicAppTheme {
        AlbumCard(
            album = Album(
                id = "",
                title = "Nombre del Álbum",
                artist = "Nombre del Artista",
                image = "https://via.placeholder.com/150",
                description = "Descripción de prueba"
            ),
            onClick = {}
        )
    }
}
