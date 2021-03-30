package org.techtown.android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        val button : Button = findViewById(R.id.button)

        val runnable : Runnable = object : Runnable{
            override fun run() {
                Log.d("Thread-1", "Thread1 is made")
            }
        }
        val thread : Thread = Thread(runnable)

        button.setOnClickListener {
            thread.start()
        }

        Thread(object : Runnable {
            override fun run() {
                Log.d("Thread-2", "Thread2 is made")
            }
        }).start()

        Thread(Runnable {
            Thread.sleep(2000)
            Log.d("Thread-3", "Thread3 is made")
            runOnUiThread {
                button.setBackgroundColor(getColor(R.color.textview_color))
            }
        }).start()


    }
}