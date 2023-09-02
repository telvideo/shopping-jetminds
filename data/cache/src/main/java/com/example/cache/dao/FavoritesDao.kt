package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cache.models.ProductsResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {

    @Query(
        """
            SELECT * FROM `products_table`
            WHERE is_favorite = :isFavorite
            ORDER BY date_created DESC
        """
    )
    fun fetchFavoriteProducts(
        isFavorite: Boolean = true
    ): Flow<List<ProductsResponseEntity>>

    @Query("UPDATE `products_table` SET is_favorite = :isFavorite WHERE id = :id")
    suspend fun updateIsFavoriteProduct(id: Int, isFavorite: Boolean)
}