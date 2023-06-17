package com.az.wallmindui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.az.wallmindui.model.WmWallpaper

@Composable
@Preview(device = Devices.PIXEL_4, backgroundColor = 0xFFFFFFFF, showBackground = true)
fun WmFavouritePill(
    wmWallpaper: WmWallpaper = WmWallpaper(),
    onFavouriteClicked: (String) -> Unit = {}
) {
    var isFavourite by remember { mutableStateOf(wmWallpaper.isFavorite) }

    Box(modifier = Modifier.padding(10.dp)) {
        WmAnimatedButton(
            onClick = {
                onFavouriteClicked(wmWallpaper.key)
                isFavourite = !isFavourite
            },
            isFlipped = wmWallpaper.isFavorite,
            shape = RoundedCornerShape(10.dp)
        ) {
            Icon(
                painter = if (wmWallpaper.isFavorite) {
                    painterResource(R.drawable.heart)
                } else {
                    painterResource(R.drawable.heart_outline)
                },
                contentDescription = null
            )
        }
    }

}

@Composable
private fun WmAnimatedButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    isFlipped: Boolean = false,
    shape: Shape = RoundedCornerShape(10.dp),
    content: @Composable () -> Unit
) {
    val rotationY by animateFloatAsState(
        targetValue = if (isFlipped) 180f else 0f,
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (isFlipped) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.secondary
        },
        animationSpec = tween(
            durationMillis = 500,
            easing = FastOutSlowInEasing
        )
    )

    Button(
        onClick = onClick,
        shape = shape,
        colors = backgroundColor.let {
            ButtonDefaults.buttonColors(
                containerColor = it,
                contentColor = Color.White
            )
        },
        modifier = modifier.graphicsLayer(rotationY = rotationY)
    ) {
        content()
    }
}
