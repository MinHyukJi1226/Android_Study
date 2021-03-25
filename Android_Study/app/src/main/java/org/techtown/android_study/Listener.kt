package org.techtown.android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.TextValueSanitizer
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class Listener : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)


        // 뷰를 activity로 가져오는 방법
        // 1. 직접 찾아서 가져온다
        //val textView : TextView = findViewById(R.id.hello)

        // 2. xml을 import해서 가져온다
        //hello.

        val textView : TextView = findViewById(R.id.hello)
        val imageView : ImageView = findViewById(R.id.image)
        var number = 10

        // 익명함수
        // 1. 람다식
        textView.setOnClickListener {
            Log.d("click", "Click!!")
        }

        // 2. 익명 함수 방식
        textView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("click", "Click!!")
            }
        })

        // 3. 이름이 필요한 경우 (click)
        val click = object: View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("click", "Click!!")
                textView.setText("안녕하세요")
                imageView.setImageResource(R.drawable.human)
                number += 10
                Log.d("number", "" + number)
            }
        }

        textView.setOnClickListener(click)

        // 뷰를 조작하는 함수들
        // 1.setText
        // 2.setImageResource


    }
}