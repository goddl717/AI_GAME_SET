package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.Color.GRAY
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_game2_easy.*
import kotlinx.android.synthetic.main.activity_menu3.*
import java.util.*
import java.util.EnumSet.range
import kotlin.collections.ArrayList
import kotlin.concurrent.timer
import java.lang.reflect.Array as Array
import kotlin.Array as Array1

class Game2_hard : AppCompatActivity() {
    var cnt = 0
    var num = -1
    var arr_random = arrayOfNulls<Int>(25)
    var timer : Timer? = null

    override fun onBackPressed() {
        super.onBackPressed()
        timer?.cancel()
        finish()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game2_easy)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val  btn_array = arrayListOf<Button>(button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,button16)
        var origin_color = button1.background
        val random = Random()


        textView6.setText("3-BACK")

        //랜덤을 넣는 배열 생성.
        // 랜덤값 할당.
        for (i in 0..22)
            arr_random[i] = random.nextInt(16)

        for (i in 3..22) {
            val temp =   random.nextInt(3)
            if (temp == 0)
            {
                arr_random[i] = arr_random[i-3]
            }
        }

        for( i in 0..22)
            println(arr_random[i])

        //문제의 공평성을 위해서 랜덤으로 초기화한다.
        //3번째 꺼부터

        btn_game2_left.setOnClickListener {
            btn_left_click()
        }
        btn_game2_right.setOnClickListener{
            btn_right_click()
        }

        //val ran = random.nextInt(20)
        var i = 0

        timer = timer(period = 1000) {
            // 짝수면 버튼을 활성화 하고. 인덱스를 증가한다.
            if (i%2 == 0) {
                num+=1
                color_clear(btn_array)
                btn_color_change(btn_array[arr_random[num]!!])

                runOnUiThread {
                    reset_btn()
                }
            }
            else {
                color_clear(btn_array)
            }
            i +=1

            if (i == 46){
                runOnUiThread {
                    btn_game2_left.isEnabled = false
                    btn_game2_right.isEnabled = false
                }
            }
            else if (i == 47)
            {
                runOnUiThread {
                    btn_game2_left.isEnabled = false
                    btn_game2_right.isEnabled = false

                this.cancel()
                Toast.makeText(this@Game2_hard, "종료 되었습니다.", Toast.LENGTH_SHORT)
                /*
                Thread.sleep(300)
                println("total " + cnt)
                val intent = Intent(this@Game2_hard, Game2_result::class.java)
                intent.putExtra("score", cnt.toString())
                intent.putExtra("type", "3-back")
                this@Game2_hard.startActivity(intent)
                */
                }
            }
        }
    }


    private fun reset_btn()
    {
        btn_game2_left.isEnabled = true
        btn_game2_right.isEnabled = true
    }

    private fun btn_left_click() {
        if (num ==0 || num ==1 || num ==2){
            Toast.makeText(this,"4번째 부터 누를수 있습니다.",Toast.LENGTH_SHORT).show()
        }
        else if (arr_random[num] == arr_random[num-3]) {
            println("current :")
            println(num )
            println(arr_random[num] )

            println("befor 2 step:")
            println(num-3)
            println(arr_random[num-3])


            cnt += 1
        }
        else {

        }
        btn_game2_left.isEnabled = false
        btn_game2_right.isEnabled = false
    }

    fun btn_right_click(){
        if (num ==0 || num ==1 || num ==2){
            Toast.makeText(this,"4번째 부터 누를수 있습니다.",Toast.LENGTH_SHORT).show()
        }
        else if (arr_random[num] != arr_random[num-3]) {

            println("current :")
            println(num)
            println(arr_random[num] )

            println("befor 3 step:")
            println(num-3)
            println(arr_random[num-3])

            cnt += 1
        }
        else {

        }
        btn_game2_left.isEnabled = false
        btn_game2_right.isEnabled = false
    }


}

private fun btn_color_change (b: Button){
    b.setBackgroundColor(Color.DKGRAY)
}

private fun color_clear(btn : ArrayList<Button>){
    for (i in 0..15){
        btn[i].setBackgroundColor(GRAY)
    }
}






