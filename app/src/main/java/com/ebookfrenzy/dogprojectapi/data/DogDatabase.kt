package com.ebookfrenzy.dogprojectapi.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [PicturesEntity::class], version = 1)
abstract class DogDatabase : RoomDatabase() {
    abstract fun pictureDao(): PicturesDao
}