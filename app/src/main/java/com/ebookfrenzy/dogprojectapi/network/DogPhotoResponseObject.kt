package com.ebookfrenzy.dogprojectapi.network

import com.squareup.moshi.Json

//https://dog.ceo/api/breeds/image/random
data class DogPhotoResponseObject(
    @Json(name = "message") val imageUrl: String?,
    @Json(name = "status") val statusResponse: String

)
