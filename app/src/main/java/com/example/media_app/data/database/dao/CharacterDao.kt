package com.example.media_app.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.media_app.data.database.entity.CharacterEntity

@Dao
interface CharacterDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(obj: CharacterEntity)

    @Insert(onConflict = REPLACE)
    suspend fun insert(obj: List<CharacterEntity>)

    @Delete
    suspend fun delete(obj: CharacterEntity)

    @Query("DELETE FROM TABLE_CHARACTER")
    suspend fun deleteAll()

    @Query("SELECT * FROM TABLE_CHARACTER")
    suspend fun getList(): List<CharacterEntity>
}