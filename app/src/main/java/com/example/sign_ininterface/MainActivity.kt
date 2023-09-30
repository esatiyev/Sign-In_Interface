package com.example.sign_ininterface

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


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

        var text = ""
        var duration = Toast.LENGTH_LONG
        var toast : Toast

        btn1.setOnClickListener() {
            if( checkAuthentication(username.text.toString(), password.text.toString(), users) ) {
                check.setTextColor(Color.GREEN)
                check.text = "Hello, " + username.text.toString()

                text = "SUCCESSFULLY"
                toast = Toast.makeText(this, text, duration )
                toast.show()
            }
            else {
                check.text = "Username or password isn't correct!"
                check.setTextColor(Color.RED)

                text = "UNSUCCESSFULLY!!!"
                toast = Toast.makeText(this, text, duration )
                toast.show()
            }
        }



    }
    fun checkAuthentication(username: String, password: String, users: List<Map<String, Any>>): Boolean {
        for (user in users) {
            if (username == user["username"] && password == user["password"])
                return true
        }
        return false
    }

}