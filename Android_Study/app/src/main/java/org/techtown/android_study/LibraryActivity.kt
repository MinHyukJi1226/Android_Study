package org.techtown.android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val glide : ImageView = findViewById(R.id.glide)
        val glide2 : ImageView = findViewById(R.id.glide2)

        Glide.with(this@LibraryActivity)
            .load("https://i.pinimg.com/originals/86/ec/51/86ec51c589d572db18481beddfc8188a.jpg")
            .centerCrop()
            .into(glide)

        Glide.with(this@LibraryActivity)
            .load("https://i.pinimg.com/originals/86/ec/51/86ec51c589d572db18481beddfc8188a.jpg")
            .into(glide2)
    }
}