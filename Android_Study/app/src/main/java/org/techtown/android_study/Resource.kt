package org.techtown.android_study

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        val button : Button = findViewById(R.id.button)

        //1
        val ment = resources.getString(R.string.hello)
        Log.d("ment", "ment : " + ment)

        //2
        val ment2 = getString(R.string.hello)
        Log.d("ment", "ment : " + ment2)

        // SDK 버전에 다른 분기 처리
        val color = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            getColor(R.color.textview_color)
        } else {
            resources.getColor(R.color.textview_color)
        }
        Log.d("ment", "color : " + color)

        button.setBackgroundColor(getColor(R.color.textview_color))
    }
}