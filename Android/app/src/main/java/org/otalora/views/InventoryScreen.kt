package org.otalora.views

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.otalora.model.Repository
import org.otalora.utils.NavigationState
import org.otalora.views.ui.theme.AndroidTheme
import org.otalora.model.Car


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

    val scope = rememberCoroutineScope()
    var cars by remember { mutableStateOf(listOf<Car>()) }

    LaunchedEffect(Unit) {
        NavigationState.selectedScreen = "inventory"
        selectedScreen = "inventory"

        try {
            val result = Repository.getAvailableCars()
            cars = result
            Log.d("API_TEST_COCHES", "Coches recibidos (${cars.size}):")
            cars.forEach { car ->
                Log.d("API_TEST_COCHES", "-> ${car.modelo} - ${car.precioVenta}€")
            }
        } catch (e: Exception) {
            Log.e("API_TEST_COCHES", "Error al obtener coches: ${e.message}", e)
        }

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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (cars.isEmpty()) {
                item { // item temporal mientras carga
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Cargando coches...")
                    }
                }
            } else {
                items(cars) { car ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "${car.modelo.marca} ${car.modelo.nombre} (${car.anio})",
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text(text = "${car.caballos} CV")
                                Text(text = car.combustible)
                                Text(text = "${car.kilometraje} km")
                            }
                            Text(
                                text = "${car.precioVenta}€",
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                }

            }
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
