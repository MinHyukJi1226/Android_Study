package org.techtown.android_study

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PhoneBookWithRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_with_recycler_view)

        val phonebook_recycler_view: RecyclerView = findViewById(R.id.phoneBook_recycler_View)

            with(phonebook_recycler_view) {
                this.adapter = PhoneBookRecyclerAdapter(
                    createFakePhoneBook(30),
                    LayoutInflater.from(this@PhoneBookWithRecyclerViewActivity),
                    this@PhoneBookWithRecyclerViewActivity
                )

                this.layoutManager = LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)
            }

//        phonebook_recycler_view.adapter = phoneBookRecyclerAdapter
//        phonebook_recycler_view.layoutManager = LinearLayoutManager(this)

    }

    fun createFakePhoneBook(
        fakeNumber: Int,
        phoneBook: PhoneBookActivity.PhoneBook = PhoneBookActivity.PhoneBook()
    ): PhoneBookActivity.PhoneBook {
        for (i in 0 until fakeNumber) {
            phoneBook.addPerson(
                PhoneBookActivity.Person(name = "" + i + "번째 사람", number = "" + i + "번째의 사람의 전화번호")
            )
        }
        return phoneBook
    }
}

class PhoneBookRecyclerAdapter(
    val phoneBookList: PhoneBookActivity.PhoneBook,
    val inflater: LayoutInflater,
    val activity: Activity

) : RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName: TextView

        init {
            personName = itemView.findViewById(R.id.person_name)
            itemView.setOnClickListener {
                val intent = Intent(activity, PhoneBookDetailActivity::class.java)
                intent.putExtra("name", phoneBookList.personList.get(adapterPosition).name)
                intent.putExtra("number", phoneBookList.personList.get(adapterPosition).number)
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.phonebook_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(phoneBookList.personList.get(position).name)
    }

    override fun getItemCount(): Int {
        return phoneBookList.personList.size
    }
}