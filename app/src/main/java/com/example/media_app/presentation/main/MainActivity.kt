package com.example.media_app.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.media_app.R
import com.example.media_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()/*, NavigationView.OnNavigationItemSelectedListener*/ {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = findNavController(R.id.fragment_nav_host)
        setupActionBar(navController)
//        setupSideMenu(navController)
        setupBottomNavMenu(navController)

//        setupActionBarWithNavController(navController)
//        binding.navigationLayout.setupWithNavController(navController)
//        binding.bottomNavigation.setupWithNavController(navController)
    }

    private fun setupActionBar(navController: NavController) {
        setSupportActionBar(binding.toolbar)
        val appBarConfiguration = AppBarConfiguration(
                topLevelDestinationIds = setOf(
                        R.id.news_fragment,
                        R.id.search_fragment,
                        R.id.favorite_fragment
                )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun setupBottomNavMenu(navController: NavController) {
        binding.bottomNavigation.setupWithNavController(navController)
    }
}