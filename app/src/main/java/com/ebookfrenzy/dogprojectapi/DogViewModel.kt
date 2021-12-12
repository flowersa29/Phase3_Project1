package com.ebookfrenzy.dogprojectapi

import androidx.lifecycle.*
import com.ebookfrenzy.dogprojectapi.data.PicturesEntity
import com.ebookfrenzy.dogprojectapi.network.ApplicationManager
import com.ebookfrenzy.dogprojectapi.network.DogPhotoApiService
import com.ebookfrenzy.dogprojectapi.network.DogPhotoResponseObject
import kotlinx.coroutines.launch

class DogViewModel() : ViewModel() {
   private val _dogPhoto = MutableLiveData<DogPhotoResponseObject>()
   val dogPhoto: LiveData<DogPhotoResponseObject> = _dogPhoto

   init {
      getNewPhoto()
   }

   fun getNewPhoto() {
      viewModelScope.launch {
         val dogObject = DogPhotoApiService.DogPhotoApi.retrofitService.getRandomPhoto()
         _dogPhoto.value = dogObject
         // Insert new data to Room
         ApplicationManager.db.pictureDao()
            .insertPictures(
               PicturesEntity(
                  null,
                  message = dogObject.imageUrl,
                  status = dogObject.statusResponse)
            )
      }
   }

}





