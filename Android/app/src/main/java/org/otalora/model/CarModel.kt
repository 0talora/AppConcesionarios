package org.otalora.model

data class CarModel(
    val id: Int,
    val nombre: String,
    val marca: String,
    val puertas: Int,
    val anioLanzamiento: Int,
    val anioCese: Int? = null
)
