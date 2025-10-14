package org.otalora.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.otalora.utils.NavigationState
import org.otalora.views.ui.theme.AndroidTheme

class InventoryScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidTheme {
                InventoryScreenContent()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryScreenContent() {
    var selectedScreen by remember { mutableStateOf(NavigationState.selectedScreen) }

    LaunchedEffect(Unit) {
        NavigationState.selectedScreen = "inventory"
        selectedScreen = "inventory"
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Coches"
                )
            })
        },
        bottomBar = {
            BottomNavigationBar(selectedScreen) { selectedScreen = it }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InventoryScreenPreview() {
    AndroidTheme {
        InventoryScreenContent()
    }
}
