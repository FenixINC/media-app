package com.example.media_app.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.example.media_app.R

fun createProgressBar(context: Context) = AlertDialog.Builder(context)
        .setView(R.layout.layout_progress)
        .setCancelable(false)
        .create()