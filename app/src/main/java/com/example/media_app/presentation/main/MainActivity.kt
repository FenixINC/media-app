package com.example.media_app.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import com.example.media_app.R
import com.example.media_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setSupportActionBar(mBinding.toolbar)

    }

    override fun onSupportNavigateUp() = findNavController(this, R.id.fragment_nav_host).navigateUp()
}