package com.ebookfrenzy.dogprojectapi.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pictures")
data class PicturesEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @Transient
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "current_image_Url")
    val message: String?,

    @ColumnInfo(name = "Status")
    val status: String
)