package org.otalora.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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