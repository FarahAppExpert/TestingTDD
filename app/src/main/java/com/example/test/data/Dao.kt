package com.example.test.data

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao


@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)

    @Query("SELECT * FROM Items")
    fun observeAllItems(): LiveData<List<Item>>

    @Query("SELECT SUM(price * amount) FROM Items")
    fun observeTotalPrice(): LiveData<Float>
}