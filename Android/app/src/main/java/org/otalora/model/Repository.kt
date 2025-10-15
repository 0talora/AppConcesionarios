package org.otalora.model

import android.util.Log
import org.otalora.network.NetworkClient

object Repository {
    private val api = NetworkClient.apiService

    suspend fun getAvailableCars(): List<Car> {
        return try {
            val cars = api.getAvailableCars()
            Log.d("API_TEST", "Se recibieron ${cars.size} coches desde la API")
            cars
        } catch (e: Exception) {
            Log.e("API_TEST", "Error al obtener coches: ${e.message}", e)
            emptyList()
        }
    }

    suspend fun getDealerShips():List<DealerShip>{
        return try {
            val dealerShips = api.getDealerShips()
            Log.d("API_TEST", "Se recibieron ${dealerShips.size} concesionarios desde la API")
            dealerShips
        } catch (e: Exception){
            Log.e("API_TEST", "Error al obtener concesionaros: ${e.message}", e)
            emptyList()
        }
    }

}