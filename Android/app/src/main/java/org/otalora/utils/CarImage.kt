package org.otalora.views.components

import android.graphics.BitmapFactory
import android.util.Base64
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp

@Composable
fun CarImage(base64String: String) {
    val bitmap = try {
        if (base64String.isNotEmpty()) {
            val imageBytes = Base64.decode(base64String, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
        } else null
    } catch (e: Exception) {
        null
    }

    if (bitmap != null) {
        Image(bitmap = bitmap.asImageBitmap(), contentDescription = null, modifier = Modifier.size(120.dp))
    } else {
        Box(modifier = Modifier.size(120.dp), contentAlignment = Alignment.Center) {
            Text(text="No imagen")
        }
    }
}