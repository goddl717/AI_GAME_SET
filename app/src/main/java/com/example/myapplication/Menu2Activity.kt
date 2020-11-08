package com.example.myapplication

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu2.*

class Menu2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


        btn_game2_easy.setOnClickListener {
            val nextIntent = Intent(this, Game2_easy::class.java)
            startActivity(nextIntent)
        }

        btn_game2_hard.setOnClickListener {
            val nextIntent = Intent(this, Game2_hard::class.java)
            startActivity(nextIntent)
        }
    }
}