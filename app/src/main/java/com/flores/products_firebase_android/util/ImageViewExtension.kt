package com.flores.products_firebase_android.util

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.showImage(url: String) {
    Picasso.with(this.context).load(url).into(this)
}