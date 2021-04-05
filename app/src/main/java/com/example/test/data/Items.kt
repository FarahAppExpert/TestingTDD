package com.example.test.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Items")
data class Item(
        var name: String,
        var amount: Int,
        var price: Float,
        var imageUrl: String,
        @PrimaryKey(autoGenerate = true)
        val id: Int? = null
)