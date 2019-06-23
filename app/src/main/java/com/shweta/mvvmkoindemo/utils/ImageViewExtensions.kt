package com.shweta.mvvmkoindemo.utils

import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object ImageViewExtensions {

    /*@BindingAdapter("app:circleImageUrl", "app:placeHolder", requireAll = false)
    @JvmStatic
    fun loadImage(view: AppCompatImageView, url: Any?, placeHolder: Drawable) {
        url?.let { image ->
            val requestBuilder = Glide.with(view.context).load(image)
            requestBuilder.apply(RequestOptions().placeholder(placeHolder))
                .apply(RequestOptions().circleCrop()).into(view)
        }
    }*/
}