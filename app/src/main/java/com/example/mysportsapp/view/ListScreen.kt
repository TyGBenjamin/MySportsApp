package com.example.mysportsapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.mysportsapp.model.data.entity.FavPlayer

@Suppress("FunctionNaming")
@Composable
fun ListScreen(
    players: List<FavPlayer>
) {
    LazyColumn(state = rememberLazyListState(), modifier = Modifier.padding(5.dp)) {
        items(items = players) { player ->
            PlayerRow(
                player = player,
            )
        }
    }
}

@Suppress("FunctionNaming")
@Composable
fun ImageThumbnail(player: FavPlayer) {
    Image(
        modifier = Modifier.clip(CircleShape),
        painter = rememberAsyncImagePainter(player.strThumb),
        contentDescription = "user place holder"
    )
}

@Suppress("FunctionNaming")
@Composable
fun PlayerRow(player: FavPlayer) {
    Column() {
        Row(modifier = Modifier.fillMaxWidth()) {
            ImageThumbnail(player)
            Text(
                text = player.strPlayer!!,
                color = Color.White,
                fontSize = 25.sp
            )
        }
        Text(text = player.strDescriptionEN!!)
    }
}

//val painter = rememberAsyncImagePainter("https://example.com/image.jpg")
//
//AsyncImage(
//model = "https://example.com/image.jpg",
//contentDescription = null,
//)
