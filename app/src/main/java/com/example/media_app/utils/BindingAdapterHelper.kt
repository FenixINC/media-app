package com.example.media_app.utils

import android.text.TextUtils
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.media_app.R
import com.example.media_app.data.entity.Article
import timber.log.Timber

object BindingAdapterHelper {

    @JvmStatic
    @BindingAdapter("bindImage")
    fun setImage(@NonNull imageView: ImageView, @NonNull article: Article) {
        if (TextUtils.isEmpty(article.urlToImage)) {
            Glide.with(imageView.context)
                    .load("")
                    .placeholder(R.color.grey)
                    .error(R.color.grey)
                    .into(imageView)
            Timber.w("Not preview image for tvShow: %s", article.toString())
            return
        }
        Glide.with(imageView.context)
                .load(article.urlToImage)
                .placeholder(R.color.grey)
                .error(R.color.grey)
                .into(imageView)
    }
}