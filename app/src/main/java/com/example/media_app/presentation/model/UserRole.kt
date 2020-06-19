package com.example.media_app.presentation.model

import androidx.annotation.ColorRes
import androidx.annotation.StyleRes
import com.example.media_app.R

enum class UserRole(
        val asString: String/*,
        @ColorRes val color: Int,
        @ColorRes val colorDark: Int,
        @StyleRes val dialogTheme: Int*/
) {
//    USER("user", R.color.app_red, R.color.app_red_dark, R.style.dreamer_date_picker),
//    ADMIN("admin", R.color.app_blue, R.color.app_blue_dark, R.style.doer_date_picker);

    ADMIN("admin"),
    USER("user");

    companion object {
        fun getRole(role: String) = values().first { it.asString == role }
    }
}