package com.example.media_app.presentation.base

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.media_app.R

abstract class BaseActivity : AppCompatActivity() {

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    @IdRes
    protected val fragmentHostId = R.id.fragment_nav_host

    override fun onSupportNavigateUp() = Navigation.findNavController(this, fragmentHostId).navigateUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val view = findViewById<View>(fragmentHostId)
        if (view is BaseFragment<*>) {
            view.onBackPressed()
        }
    }

    protected fun getPrimaryColor(): Int {
        val colorValue = TypedValue()
        theme.resolveAttribute(R.attr.colorPrimary, colorValue, true)
        return colorValue.data
    }
}