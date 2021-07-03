package com.monofire.spacexapp.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.monofire.spacexapp.R

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 03.07.2021 - 17:46          │
//└─────────────────────────────┘
@BindingAdapter("app:imgUrl")
fun ImageView.setImageUrl(url: String?) {
    Glide.with(this)
        .load(url)
        .centerCrop()
        .apply(RequestOptions.bitmapTransform(RoundedCorners(12)))
        .placeholder(R.drawable.ic_search)
        .into(this)
}