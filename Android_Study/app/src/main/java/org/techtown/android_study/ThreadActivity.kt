package org.techtown.android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)


        val runnable : Runnable = object : Runnable{
            override fun run() {
                Log.d("Thread-1", "Thread is made")
            }
        }
        val thread : Thread = Thread(runnable)
        thread.start()

    }
}