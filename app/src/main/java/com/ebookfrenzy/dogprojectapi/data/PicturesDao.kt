package com.ebookfrenzy.dogprojectapi.data

import android.graphics.Picture
import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface PicturesDao {

    @Query("SELECT * FROM pictures")
    suspend fun getAllPictures(): List<PicturesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertPictures(dogPictureEntity: PicturesEntity )

    @Query("SELECT * FROM pictures ORDER BY id DESC LIMIT 1")
    suspend fun getLastPicture(): PicturesEntity

    @Delete
    suspend fun deletePicture(picture: PicturesEntity)
}