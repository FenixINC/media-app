package com.example.media_app.data.database.dao

import androidx.room.*
import com.example.media_app.data.database.entity.LoginEntity

@Dao
interface LoginDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: LoginEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: List<LoginEntity>)

    @Delete
    suspend fun delete(obj: LoginEntity)

    @Query("DELETE FROM TABLE_CHARACTER")
    suspend fun deleteAll()

    @Query("SELECT * FROM TABLE_CHARACTER")
    suspend fun getList(): List<LoginEntity>

    @Query("SELECT * FROM TABLE_LOGIN WHERE email = :email AND password = :password")
    suspend fun getUser(email: String, password: String): LoginEntity
}