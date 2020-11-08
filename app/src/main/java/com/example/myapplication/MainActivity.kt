package com.example.myapplication

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        btn_menu1.setOnClickListener{
            val nextIntent = Intent(this, Menu1Activity::class.java)
            startActivity(nextIntent)
        }

        btn_menu2.setOnClickListener{
            val nextIntent = Intent(this, Menu2Activity::class.java)
            startActivity(nextIntent)
        }

        btn_menu3.setOnClickListener{
            val nextIntent = Intent(this, Menu3Activity::class.java)
            startActivity(nextIntent)
        }


        //println(parseInt("ㅡ").toString())
    }


}