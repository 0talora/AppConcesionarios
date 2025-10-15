package org.otalora

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.otalora.model.Repository
import org.otalora.ui.theme.AndroidTheme
import org.otalora.views.HomeScreen
import org.otalora.views.InventoryScreenContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        lifecycleScope.launch {
//            try {
//                val cars = Repository.getAvailableCars()
//                Log.d("API_TEST_COCHES", "Coches recibidos (${cars.size}):")
//                cars.forEach { car ->
//                    Log.d("API_TEST_COCHES", "-> ${car.modelo} - ${car.precioVenta}€")
//                }
//            } catch (e: Exception) {
//                Log.e("API_TEST_COCHES", "Error al obtener coches: ${e.message}", e)
//            }
//
//            try {
//                val dealerShips= Repository.getDealerShips()
//                Log.d("API_TEST_CONCESIONARIOS", "Concesionarios Recibidos (${dealerShips.size})")
//                dealerShips.forEach { dealerShip ->
//                    Log.d("API_TEST_CONCESIONARIOs", "-> ${dealerShip.nombre}")
//                }
//            } catch (e: Exception){
//                Log.e("API_TEST_CONCESIONARIOS", "Error al obtener coches: ${e.message}", e)
//            }
//        }

        setContent {
            AndroidTheme {
                InventoryScreenContent()
            }
        }
    }
}
