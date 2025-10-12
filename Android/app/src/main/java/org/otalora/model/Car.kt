package org.otalora.model

data class Car(
    val id: Int,
    val modelo: CarModel,
    val color: String,
    val anio: Int,
    val kilometraje: Int,
    val caballos: Int,
    val combustible: String,
    val cubicaje: Double,
    val matricula: String,
    val paisOrigen: String,
    val precioVenta: Double,
    val concesionario: DealerShip
)
