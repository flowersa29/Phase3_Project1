package com.ebookfrenzy.dogprojectapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebookfrenzy.dogprojectapi.network.DogPhotoApiService
import com.ebookfrenzy.dogprojectapi.network.DogPhotoResponseObject
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {
   private val _dogPhoto = MutableLiveData<DogPhotoResponseObject>()
   val dogPhoto: LiveData<DogPhotoResponseObject> = _dogPhoto


   init {
      getNewPhoto()
   }

   fun getNewPhoto() {
      viewModelScope.launch {

         _dogPhoto.value = DogPhotoApiService.DogPhotoApi.retrofitService.getRandomPhoto()

      }
   }
}