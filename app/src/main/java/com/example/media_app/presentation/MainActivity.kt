package com.example.media_app.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.media_app.R
import com.example.media_app.databinding.ActivityMainBinding
import com.example.media_app.presentation.top_headline.TopHeadlineFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(mBinding.toolbar as Toolbar)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, TopHeadlineFragment.newInstance())
            .commit()
    }
}