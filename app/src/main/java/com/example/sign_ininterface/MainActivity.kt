package com.example.sign_ininterface

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var users = listOf(
            mapOf("username" to "esatiyev", "password" to "elton123")
        )
        var username = findViewById<EditText>(R.id.username)
        var password = findViewById<EditText>(R.id.password)
        var btn1 = findViewById<Button>(R.id.sign_in)
        var check = findViewById<TextView>(R.id.checking)

        btn1.setOnClickListener() {
            if( findUser(username.text.toString(), password.text.toString(), users) ) {
                check.text = "Hello, " + username.text.toString()
            }
            else {
                check.text = "Username or password isn't correct!"
                check.setTextColor(Color.RED)
            }
        }



    }
    fun findUser(username: String, password: String, users: List<Map<String, Any>>): Boolean {
        for (user in users) {
            if (username == user["username"] && password == user["password"])
                return true
        }
        return false
    }

}