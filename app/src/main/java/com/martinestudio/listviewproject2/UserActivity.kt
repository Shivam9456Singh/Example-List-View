package com.martinestudio.listviewproject2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phoneNumber")
        val imageId = intent.getIntExtra("imgId", R.drawable.img9)
        val lastMessage = intent.getStringExtra("lastMsg")
        val lastMessageTime = intent.getStringExtra("lastMsgTime")

        val nameTv = findViewById<TextView>(R.id.tvName)
        val phoneNumberTv = findViewById<TextView>(R.id.tvPhone)
        val image = findViewById<CircleImageView>(R.id.profile_image)
        val lastMsgtv = findViewById<TextView>(R.id.tvlastMsg)
        val lastMsgTime = findViewById<TextView>(R.id.tvlastMsgTime)

        nameTv.text = "Name: $name"
        phoneNumberTv.text = "Contact: $phoneNumber"
        image.setImageResource(imageId)
        lastMsgtv.text = "Last Message: $lastMessage"
        lastMsgTime.text = "Last Online at : $lastMessageTime"

    }
}