package com.example.media_app.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.media_app.R
import com.example.media_app.presentation.top_headline.TopHeadlineFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, TopHeadlineFragment.newInstance())
            .commit()
    }
}