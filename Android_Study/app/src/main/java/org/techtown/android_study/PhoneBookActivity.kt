package org.techtown.android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import org.w3c.dom.Text

class PhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book)
    }

    fun createFakePhoneBook(fakeNumber : Int, phoneBook: PhoneBook = PhoneBook()) : PhoneBook {
        for (i in 0 until fakeNumber){
            phoneBook.addPerson(
               Person(name = "" + i + "번째 사람", number = "" + i + "번째의 사람의 전화번호")
            )
        }
        return phoneBook
    }

    fun createPhoneBookList(phoneBook: PhoneBook){
        val layoutInflater = LayoutInflater.from(this)
        val container = findViewById<LinearLayout>(R.id.phoneBook_list_container)
        for (i in 0 until phoneBook.personList.size){
            val view = layoutInflater.inflate(R.layout.phonebook_item, null)
            val personNameView = view.findViewById<TextView>(R.id.person_name)
        }
    }
}

class PhoneBook() {
    // 전화번호부
    val personList = ArrayList<Person>()

    fun addPerson(person: Person){
        personList.add(person)
    }
}

class Person(var name : String, var number : String){

}