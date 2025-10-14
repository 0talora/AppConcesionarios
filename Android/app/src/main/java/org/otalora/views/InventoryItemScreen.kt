package org.otalora.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.otalora.utils.NavigationState
import org.otalora.views.ui.theme.AndroidTheme

class InventoryItem : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidTheme {
                InventoryItemContent()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryItemContent() {

    var selectedScreen by remember { mutableStateOf(NavigationState.selectedScreen) }

    LaunchedEffect(Unit) {
        NavigationState.selectedScreen = "inventory"
        selectedScreen = "inventory"
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Inventory Item"
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
            Text("Bienvenido a Inventory Item 👋")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InventoryItemPreview() {
    AndroidTheme {
        InventoryItemContent()
    }
}
