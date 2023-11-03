package ru.rsttur.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ErrorContent(isDisplayed: Boolean = false) {

}

@Composable
fun LoadingContent(isDisplayed: Boolean, animationDelay: Int = 1200) {
    if(isDisplayed) {
        Box(modifier = Modifier.padding(top = 300.dp)) {
            val circleColor: Color = Color.Magenta
            var circleScale by remember {
                mutableStateOf(0f)
            }
            val circleScaleAnimate = animateFloatAsState(
                targetValue = circleScale,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = animationDelay
                    )
                )
            )

            LaunchedEffect(Unit) {
                circleScale = 1f
            }

            Box(
                modifier = Modifier
                    .size(size = 64.dp)
                    .scale(scale = circleScaleAnimate.value)
                    .border(
                        width = 4.dp,
                        color = circleColor.copy(alpha = 1 - circleScaleAnimate.value),
                        shape = CircleShape
                    )
            ) {
            }
        }
    }
}