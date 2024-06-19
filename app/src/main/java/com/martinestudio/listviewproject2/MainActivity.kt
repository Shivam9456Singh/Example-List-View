package com.martinestudio.listviewproject2

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

     lateinit var userArrayList:ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val name = arrayOf("Heyline kokouro",
            "Picline inkit",
            "Alexidra senroff",
            "Thomas alwa",
            "Dwen Tenison",
            "Hery porter",
            "Bumble bee",
            "Helina Rox",
            "Rosie Simposon")

        val lastMsg = arrayOf("Hii there",
            "Wanna have some fun",
            "Meet you soon",
            "Hey there I wanna share something",
            "Bye, it was nice meeting",
            "I am busy",
            "I am not available",
            "It was a great Night with you",
            "I am not available for service at Night")

        val lastMsgTime = arrayOf("6:30 am",
            "10:00 am",
            "12:00 pm",
            "4:10 pm",
            "8:30 pm",
            "11:30 am",
            "1:00 pm",
            "12:20 pm",
            "1:40 pm")
        val phoneNumber = arrayOf("8456123579",
            "9874563210",
            "8474568484",
            "7854698531",
            "9874563210",
            "8474568484",
            "9304569875",
            "2845631594",
            "7896541230")

        val imgId = intArrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9
        )


        userArrayList = ArrayList()

        for(eachIndex in name.indices){
            val user = User(
                name[eachIndex],
                lastMsg[eachIndex],
                lastMsgTime[eachIndex],
                phoneNumber[eachIndex],
                imgId[eachIndex])

            userArrayList.add(user)

        }

        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true
        listView.adapter = CustomAdapter(this,userArrayList)

        listView.setOnItemClickListener { parent, view, position, id ->
            val userName = name[position]
            val userPhoneNumber = phoneNumber[position]
            val userImg = imgId[position]
            val userLastMsg = lastMsg[position]
            val userLastMsgTime = lastMsgTime[position]

            val i = Intent(this,UserActivity::class.java)
            i.putExtra("name",userName)
            i.putExtra("phoneNumber",userPhoneNumber)
            i.putExtra("imgId",userImg)
            i.putExtra("lastMsg",userLastMsg)
            i.putExtra("lastMsgTime",userLastMsgTime)
            startActivity(i)

            Toast.makeText(this,"Viewing $userName profile..",Toast.LENGTH_SHORT).show()
        }
    }
}