package com.example.myapplication

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game2_result.*

class Game2_result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game2_result)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val type = intent.getStringExtra("type")
        val score = intent.getStringExtra("score")

        game2_score.setText(type)
        game2_type.setText(score+"/20")

    }





}