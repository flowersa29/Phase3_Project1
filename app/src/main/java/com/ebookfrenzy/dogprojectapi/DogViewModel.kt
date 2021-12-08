package com.ebookfrenzy.dogprojectapi

import androidx.lifecycle.*
import com.ebookfrenzy.dogprojectapi.data.PicturesDao
import com.ebookfrenzy.dogprojectapi.data.PicturesEntity
import com.ebookfrenzy.dogprojectapi.network.DogPhotoApiService
import com.ebookfrenzy.dogprojectapi.network.DogPhotoResponseObject
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class DogViewModel(private val picturesDao: PicturesDao) : ViewModel() {
   private val _dogPhoto = MutableLiveData<DogPhotoResponseObject>()
   val dogPhoto: LiveData<DogPhotoResponseObject> = _dogPhoto

   fun insertNewPicture(picturesEntity: PicturesEntity){
      viewModelScope.launch{
         picturesDao.insertPictures(picturesEntity)
      }
   }
   init {
      getNewPhoto()
   }

   fun getNewPhoto() {
      viewModelScope.launch {

         _dogPhoto.value = DogPhotoApiService.DogPhotoApi.retrofitService.getRandomPhoto()

      }
   }

}





