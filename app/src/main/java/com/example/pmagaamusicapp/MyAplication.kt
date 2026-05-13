package com.example.pmagaamusicapp

import android.app.Application
import coil3.ImageLoader
import coil3.SingletonImageLoader

class MyApplication : Application(), SingletonImageLoader.Factory {
    override fun newImageLoader(context: android.content.Context): ImageLoader {
        return buildImageLoader(context)
    }
}