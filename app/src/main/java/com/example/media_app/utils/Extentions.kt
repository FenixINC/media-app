package com.example.media_app.utils

import android.app.Activity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
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
fun Activity.showSnackbarShort(view: View, text: String) {
    Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show()
}

fun Fragment.showSnackbarShort(view: View, text: String) {
    Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show()
}

fun Activity.showSnackbarLong(view: View, text: String) {
    Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
}

fun Fragment.showSnackbarLong(view: View, text: String) {
    Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
}

//------ Delegate
fun TextView.text(): ReadWriteProperty<Any, String> =
        object : ReadWriteProperty<Any, String> {
            override fun getValue(thisRef: Any, property: KProperty<*>): String = text.toString()

            override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
                text = value
            }
        }