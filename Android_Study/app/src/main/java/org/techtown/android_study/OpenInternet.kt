package org.techtown.android_study

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText

class OpenInternet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_internet)

        var address_edit_text : EditText = findViewById(R.id.address_edit_text)
        val open : Button = findViewById(R.id.open)

        open.setOnClickListener {
            val address = address_edit_text.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(address))
            startActivity(intent)
        }
        
        address_edit_text.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if(s.toString() == "abc")
                    Log.d("edit", "Text is abc")
                Log.d("edit", "beforeTextCanged : " + s)

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("edit", "onTextChaged : " + s)
            }

            override fun afterTextChanged(s: Editable?) {
                Log.d("edit", "afterTextChanged : " + s)
            }
        })
    }
}