package com.clean.persistence.db.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserRoomDao {

    @Query("SELECT * FROM user")
    fun getUsers(): Flow<List<UserRoomEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: List<UserRoomEntity>)
}