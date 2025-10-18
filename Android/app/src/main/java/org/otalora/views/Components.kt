package org.otalora.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.otalora.model.Car
import org.otalora.views.components.CarImage
import org.otalora.views.ui.theme.AndroidTheme

@Composable
fun BottomNavigationBar(selected: String, onSelect: (String) -> Unit) {
    NavigationBar {
        NavigationBarItem(
            selected = selected == "coches",
            onClick = { onSelect("coches") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Coches") },
            label = { Text("Coches") }
        )
        NavigationBarItem(
            selected = selected == "favoritos",
            onClick = { onSelect("favoritos") },
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Favoritos") },
            label = { Text("Favoritos") }
        )
    }
}

@Composable
fun CarCard(car: Car) {
    var currentPhotoIndex by remember { mutableStateOf(0) }

    Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp), elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.fillMaxWidth().weight(1f)) {
                    Text("${car.modelo.marca} ${car.modelo.nombre} ", style = MaterialTheme.typography.titleMedium)
                    Text("${car.caballos} CV | ${car.combustible} | ${car.anio} \n${car.kilometraje} km")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            if (car.fotos.isNotEmpty()) {
                val fotoActual = car.fotos[currentPhotoIndex]

                Box(modifier = Modifier.fillMaxWidth().height(250.dp).clickable { currentPhotoIndex = (currentPhotoIndex + 1) % car.fotos.size }, contentAlignment = Alignment.Center) {
                    CarImage(base64String = fotoActual.imagenBase64, modifier = Modifier.fillMaxSize())
                }

                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Foto ${currentPhotoIndex + 1} de ${car.fotos.size}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            } else {
                Text("No hay fotos disponibles")
            }
            Text("${car.precioVenta}€", color=Color.Yellow, style = MaterialTheme.typography.titleMedium.copy(fontSize = 24.sp)
            )
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}