package com.rgbfilters.app

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.rgbfilters.app.ColorFilter.filterImage


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.sample)
        val pixels = IntArray(bitmap.width * bitmap.height)

        bitmap.getPixels(pixels, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)

        val filteredPixels = filterImage(pixels, bitmap.width, bitmap.height)

        val filteredBitmap = Bitmap.createBitmap(
            filteredPixels,
            bitmap.width,
            bitmap.height,
            Bitmap.Config.ARGB_8888
        )

        imageView.setImageBitmap(filteredBitmap)
    }
}