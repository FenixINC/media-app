package com.example.media_app.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TopHeadline(

    @SerializedName("status")
    var status: String? = "",

    @SerializedName("totalResults")
    var totalResults: Int? = 0,

    @SerializedName("articles")
    var articles: List<Article>
) : Parcelable