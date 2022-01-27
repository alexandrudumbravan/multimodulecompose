package com.clean.persistence.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.clean.persistence.db.post.PostRoomDao
import com.clean.persistence.db.post.PostRoomEntity
import com.clean.persistence.db.user.UserRoomDao
import com.clean.persistence.db.user.UserRoomEntity

@Database(entities = [UserRoomEntity::class, PostRoomEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserRoomDao

    abstract fun postDao(): PostRoomDao
}