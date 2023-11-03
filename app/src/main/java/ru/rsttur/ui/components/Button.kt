package ru.rsttur.ui.components

import MyIcon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.rsttur.utils.getColor
import ru.rsttur.utils.getIconDestination

@Composable
fun GradientButton(title: String, icon: String, color: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp, horizontal = 2.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        Button(
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = getColor(color),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(10.dp),
            onClick = {},
        ) {
            MyIcon(resId = getIconDestination(icon), modifier = Modifier.size(24.dp))
            Text(
                modifier = Modifier.padding(horizontal = 5.dp),
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 20.sp,
            )
        }
    }
}