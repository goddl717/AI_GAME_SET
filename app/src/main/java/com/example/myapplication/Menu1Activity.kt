package com.example.myapplication

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu1.*

class Menu1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu1)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        btn_easy.setOnClickListener{
            val nextIntent = Intent(this, EasyActivity::class.java)
            startActivity(nextIntent)
        }


        btn_hard.setOnClickListener{
            val nextIntent = Intent(this, HardActivity::class.java)
            startActivity(nextIntent)
        }

    }




}