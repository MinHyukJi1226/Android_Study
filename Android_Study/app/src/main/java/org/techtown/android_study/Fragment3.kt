package org.techtown.android_study

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment3 : Fragment() {
    class Fragment1 : Fragment(){
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            Log.d("life_cycle", "F onCreateView")

            // 프래그먼트가 인터베이스를 처음으로 그릴때 호출된다
            // inflater -> 뷰를 그려주는 역활
            // container -> 부모뷰

            return inflater.inflate(R.layout.fragment_three, container, false)
        }
    }
}