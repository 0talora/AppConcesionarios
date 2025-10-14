package org.otalora.controller

import org.otalora.model.Car
import org.otalora.model.Repository

class InventoryController {
    suspend fun getAvailableCars(): List<Car>{
        return Repository.getAvailableCars();
    }
}