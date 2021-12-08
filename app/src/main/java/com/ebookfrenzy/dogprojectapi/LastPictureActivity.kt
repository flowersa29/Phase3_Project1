package com.ebookfrenzy.dogprojectapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ebookfrenzy.dogprojectapi.databinding.ActivityLastPictureBinding
import com.ebookfrenzy.dogprojectapi.network.DogApplication

class LastPictureActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLastPictureBinding
    private val viewModel: DogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_picture)
    }
}