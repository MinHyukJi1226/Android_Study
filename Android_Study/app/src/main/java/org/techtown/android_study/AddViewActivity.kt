package org.techtown.android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.load.engine.Engine
import java.lang.reflect.Array
import java.util.ArrayList

class AddViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)

//      아이템 리스트 준비
       val carList = ArrayList<CarForList>()
        for (i in 0 until 10){
            carList.add(CarForList("" + i + "번째 자동차", "" + i + "순위 엔진"))
        }
    }
}

class CarForList(val name : String, val engine: String) {

}