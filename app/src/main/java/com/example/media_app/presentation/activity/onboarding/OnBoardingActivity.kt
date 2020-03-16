package com.example.media_app.presentation.activity.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.media_app.R
import com.example.media_app.databinding.ActivityOnboardingBinding

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_onboarding)

        val navController = findNavController(R.id.fragment_onboarding_nav_host)
        setupActionBar(navController)

//        val isUserSignIn = true
//        when (isUserSignIn) {
//            true -> {
////                navController.navigate(R.id.action_splash_to_main_activity)
//                finish()
//            }
//            false -> {
//                navController.navigate(R.id.action_splash_to_login)
//            }
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
//        findNavController(R.id.fragment_onboarding_nav_host).navigateUp()
        onBackPressed()
        return true
    }

    private fun setupActionBar(navController: NavController) {
        setSupportActionBar(binding.toolbar)
        val appBarConfiguration = AppBarConfiguration(
                topLevelDestinationIds = setOf(
                        R.id.splash_fragment,
                        R.id.login_fragment
                )
        )
        setupActionBarWithNavController(
                navController = navController,
                configuration = appBarConfiguration
        )
    }
}