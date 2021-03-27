package org.techtown.android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class FragmentActivity : AppCompatActivity(), FragmentOne.OnDataPassListener {

    override fun onDataPass(data: String) {
        Log.d("pass","" + data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle", "onStart")

        val button : Button = findViewById(R.id.button)
        val button2 : Button = findViewById(R.id.button2)

        val fragmentOne : FragmentOne = FragmentOne()
        // 프래그먼트에 data를 넣어주는 방법
        val bundle : Bundle = Bundle()
        bundle.putString("Hello", "Hello")
        fragmentOne.arguments = bundle


        button.setOnClickListener {
            // 프래그먼트를 동적으로 작동하는 방법
            // 프라그먼트 붙이는 방법 replace, add
            val fragmentManager : FragmentManager = supportFragmentManager

            // Transaction
            // 작업의 단위 -> 시작과 끝이 있다
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, fragmentOne)
            fragmentTransaction.commit()

            // 끝을 내는 방법
            // commit -> 시간 날 때 해 (좀 더 안정정)
            // commitnow -> 지금 당장해

            button2.setOnClickListener {
                // 프라그먼트 remove/detach 하는 방법
                val fragmentManager = supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
//                fragmentTransaction.detach(fragmentOne)
                fragmentTransaction.remove(fragmentOne)

                fragmentTransaction.commit()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle", "onDestroy")
    }
}