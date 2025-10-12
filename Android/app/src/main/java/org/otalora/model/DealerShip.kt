package org.otalora.model

data class DealerShip(
    val id: Int,
    val nombre: String,
    val calle: String,
    val numero: Int,
    val ciudad: String,
    val provincia: String,
    val cp: Int,
    val telefono: Long
)
