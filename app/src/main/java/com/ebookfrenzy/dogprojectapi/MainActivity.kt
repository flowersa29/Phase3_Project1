package com.ebookfrenzy.dogprojectapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.net.toUri
import coil.load
import com.ebookfrenzy.dogprojectapi.data.PicturesEntity
import com.ebookfrenzy.dogprojectapi.databinding.ActivityMainBinding
import com.ebookfrenzy.dogprojectapi.network.DogApplication

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: DogViewModel by viewModels()
    private val IMAGE_REQUEST_CODE = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getRandomPhoto()

        // Project 3
        // TODO: Create a click listener for the capture button (make the view)
        // TODO: Create an implicit intent to navigate to picture activity
        // TODO: Start activity for result using intent and req. code
        // TODO: Get activity result when an image is captured
    }

    fun getRandomPhoto() {
        val randomPhotoButton = binding.button
        val currentImage = viewModel.dogPhoto.value!!.imageUrl
        val previousImage = currentImage?.let {
            dogImage -> PicturesEntity(message = dogImage)
        }

        viewModel.dogPhoto.observe(this, {
            val imgUri = it.imageUrl!!
                .toUri()
                .buildUpon()
                .scheme("https")
                .build()

            binding.imageView.load(imgUri)
            randomPhotoButton.setOnClickListener{
                viewModel.getNewPhoto()
            }
        })
    }
}