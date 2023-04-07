package com.example.shoppingjetminds.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.shoppingjetminds.R

@Composable
fun JetCoilImage(
    imageUrl: String?
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl!!)
            .placeholder(R.drawable.favorite)
            .crossfade(300)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}