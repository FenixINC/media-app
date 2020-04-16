package com.example.media_app.utils

import android.app.Activity
import android.os.Build
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.media_app.R
import com.google.android.material.snackbar.Snackbar
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

//------ Toast:
fun Activity.showToastShort(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Activity.showToastLong(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

fun Fragment.showToastShort(text: String) {
    Toast.makeText(this.context, text, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToastLong(text: String) {
    Toast.makeText(this.context, text, Toast.LENGTH_LONG).show()
}

//------ Snackbar
@RequiresApi(Build.VERSION_CODES.M)
fun Activity.showSnackbarShort(view: View, text: String) {
    val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
    snackbar.setTextColor(resources.getColor(R.color.white, null))
    snackbar.setBackgroundTint(resources.getColor(R.color.red, null))
    snackbar.show()
}

@RequiresApi(Build.VERSION_CODES.M)
fun Fragment.showSnackbarShort(view: View, text: String) {
    val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
    snackbar.setTextColor(resources.getColor(R.color.white, null))
    snackbar.setBackgroundTint(resources.getColor(R.color.red, null))
    snackbar.show()
}

@RequiresApi(Build.VERSION_CODES.M)
fun Activity.showSnackbarLong(view: View, text: String) {
    val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG)
    snackbar.setTextColor(resources.getColor(R.color.white, null))
    snackbar.setBackgroundTint(resources.getColor(R.color.red, null))
    snackbar.show()
}

@RequiresApi(Build.VERSION_CODES.M)
fun Fragment.showSnackbarLong(view: View, text: String) {
    val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG)
    snackbar.setTextColor(resources.getColor(R.color.white, null))
    snackbar.setBackgroundTint(resources.getColor(R.color.red, null))
    snackbar.show()
}

//------ Delegate
fun TextView.text(): ReadWriteProperty<Any, String> =
        object : ReadWriteProperty<Any, String> {
            override fun getValue(thisRef: Any, property: KProperty<*>): String = text.toString()

            override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
                text = value
            }
        }