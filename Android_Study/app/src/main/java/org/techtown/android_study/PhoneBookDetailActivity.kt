package org.techtown.android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PhoneBookDetailActivity : AppCompatActivity() {

    var person_detail_name : TextView = findViewById(R.id.person_detail_name)
    var person_detail_number : TextView = findViewById(R.id.person_detail_number)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_detail)

        val back : ImageView = findViewById(R.id.back)

        getPersonInfoAndDraw()
        back.setOnClickListener {
            onBackPressed()
        }
    }
    fun getPersonInfoAndDraw() {
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")

        person_detail_name.setText(name)
        person_detail_number.setText(number)
    }
}