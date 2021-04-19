package org.techtown.android_study

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SharePreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_preference)

        val button : Button = findViewById(R.id.button)

        // SharedPreference에 저장하는 방법법
       val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)

        // MODE_PRIVATE : 생성한 application에서만 사용가능
        // MODE_WORLD_READABLE : 다른 application 사용가능있지만 읽을수만 있다.
        // MODE_WORLD_WRITEABLE : 다른 application 사용가능하고 기록도 가능하다.
        // MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
        // MDOE_APPEND : 기존 preference에 신규 로 추가
        val editer : SharedPreferences.Editor = sharedPreference.edit()
        editer.putString("hello", "안녕하세요")
        editer.commit()

        button.setOnClickListener {
            // SharedPreferencen에 값을 불러오는 방법
            val sharedPreferences = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val value = sharedPreference.getString("hello", "데이터 없음")
            Log.d("key-value", "Value : " + value)
        }
      }
}