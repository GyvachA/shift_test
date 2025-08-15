package com.gyvacha.shift_test.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gyvacha.shift_test.data.local.dao.RandomUserDao
import com.gyvacha.shift_test.data.local.dao.RemoteKeysDao
import com.gyvacha.shift_test.data.local.entities.RandomUserEntity
import com.gyvacha.shift_test.data.local.entities.RemoteKeysEntity

@Database(
    entities = [RandomUserEntity::class, RemoteKeysEntity::class],
    version = 1,
    exportSchema = true
)
abstract class ShiftDatabase : RoomDatabase() {
    abstract fun randomUserDao(): RandomUserDao
    abstract fun remoteKeysDao(): RemoteKeysDao
}