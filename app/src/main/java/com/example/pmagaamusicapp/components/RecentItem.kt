package com.example.pmagaamusicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pmagaamusicapp.models.Album
import com.example.pmagaamusicapp.ui.theme.PMagañaMusicAppTheme

@Composable
fun RecentItem(
    album: Album,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .clickable {
                onClick()
            }
            .padding(10.dp)
    ) {

        AsyncImage(
            model = album.image,
            contentDescription = null,
            modifier = Modifier
                .size(55.dp)
                .clip(RoundedCornerShape(10.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {

            Text(text = album.title)

            Text(
                text = "${album.artist} • Popular Song",
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecentItem() {
    PMagañaMusicAppTheme {
        RecentItem(
            album = Album(
                id = 1,
                title = "Nombre del Álbum",
                artist = "Nombre del Artista",
                image = "https://via.placeholder.com/150",
                description = "Descripción de prueba"
            ),
            onClick = {}
        )
    }
}