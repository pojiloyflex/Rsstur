import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun BaseImage(url: String, modifier: Modifier = Modifier) {
    val bitmap = remember { mutableStateOf<Bitmap?>(null) }

    LaunchedEffect(url) {
        withContext(Dispatchers.IO) {
            val picasso = Picasso.get()
            picasso.load(url).get()?.let {
                withContext(Dispatchers.Main) {
                    bitmap.value = it
                }
            }
        }
    }
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(6.dp),
    ) {
        bitmap.value?.let {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawImage(it.asImageBitmap(), Offset.Zero)
            }
        }
    }
}

@Composable
fun MyIcon(@DrawableRes resId: Int, modifier: Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(id = resId),
        contentDescription = null
    )
}
