package com.example.pmagaamusicapp.components

import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.pmagaamusicapp.models.Album
import com.example.pmagaamusicapp.ui.theme.PMagañaMusicAppTheme

@Composable
fun MiniPlayer(album: Album?) {

    if (album == null) return

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF2D0B52))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            model = album.image,
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(12.dp))
        )



        Column(
            modifier = Modifier.weight(1f)
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
fun PreviewMiniPlayer() {
    PMagañaMusicAppTheme {
        MiniPlayer(
            album = Album(
                id = "",
                title = "Nombre del Álbum",
                artist = "Nombre del Artista",
                image = "https://via.placeholder.com/150",
                description = "Descripción de prueba"
            )
        )
    }
}