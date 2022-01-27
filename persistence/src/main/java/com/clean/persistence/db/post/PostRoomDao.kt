package com.clean.persistence.db.post

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PostRoomDao {

    @Query("SELECT * FROM post")
    fun getPosts(): Flow<List<PostRoomEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(users: List<PostRoomEntity>)
}