package com.webslinger.portfolio.moviemania.application.viewmodel

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

class TmdbImageLoader() {
    private val baseUrl = "https://image.tmdb.org/t/p/original"

    fun loadToImageView(
        parentView: View,
        imagePath: String,
        imageView: ImageView
    ){
        Glide.with(parentView)
            .load(baseUrl + imagePath)
            .into(imageView)
    }
}
