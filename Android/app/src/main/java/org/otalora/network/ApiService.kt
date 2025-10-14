package org.otalora.network

import org.otalora.model.Car
import org.otalora.model.DealerShip
import retrofit2.http.GET

interface ApiService {
    @GET("inventario/disponibles")
    suspend fun getAvailableCars(): List<Car>

    @GET("concesionario")
    suspend fun getDealerShips(): List<DealerShip>

}