package com.ebookfrenzy.dogprojectapi.data

import android.graphics.Picture
import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface PicturesDao {

    @Query("SELECT * FROM pictures")
    fun getAllPictures(): Flow<List<PicturesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertPictures(dogPictureEntity: PicturesEntity )



    @Query("SELECT * FROM pictures ORDER BY id DESC LIMIT 1")
    fun getNewPicture() : PicturesEntity

}