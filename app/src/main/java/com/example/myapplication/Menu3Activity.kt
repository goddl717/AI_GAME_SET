package com.example.myapplication

import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.Color.YELLOW
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu3.*
import kotlin.random.Random

class Menu3Activity : AppCompatActivity() {
    val left_word = arrayOf("노랑","초록","빨강","파랑")
    val right_word = arrayListOf("노랑","초록","빨강","파랑","낙타","악어","사자","사과")
    val color = arrayOf(Color.BLUE, Color.YELLOW,Color.GREEN,Color.RED)
    var sToast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setContentView(R.layout.activity_menu3)
        make_str()

        btn_left.setOnClickListener{
           left_click()
        }
        btn_right.setOnClickListener{
            right_click()
        }
    }

    fun make_str(){
        val random = Random
        val index1 = random.nextInt(left_word.size)
        val index2 = random.nextInt(right_word.size)

        left_view.setText(left_word[index1])
        right_view.setText(right_word[index2])


        val index3 = random.nextInt(4)
        val index4 = random.nextInt(4)

        left_view.setTextColor(color[index3])
        right_view.setTextColor(color[index4])


    }
    fun showToast(context: Context?, message: String?) {
        if (sToast == null) {
            sToast = Toast.makeText(context, message, Toast.LENGTH_SHORT)

            //sToast?.setGravity(Gravity.CENTER,0,0)
        } else {
            sToast?.cancel()
            sToast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
            //sToast!!.setGravity(Gravity.CENTER,0,0)
        }
        sToast?.show()

    }


    fun Vibration(len: Long){
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(len)
    }

    //같으면
    fun check(): Boolean {
        //노랑색이면.
        when (left_view.text){
            "노랑" -> return right_view.textColors.defaultColor == Color.YELLOW
            "초록" -> return right_view.textColors.defaultColor == Color.GREEN
            "빨강" -> return right_view.textColors.defaultColor == Color.RED
            "파랑" -> return right_view.textColors.defaultColor == Color.BLUE
        }
        return false
    }

    fun left_click(){
        if (check() == true) {
            showToast(this,"맞습니다.")
        }
        else {
            showToast(this,"틀렸습니다.")
            Vibration(1000)
        }
        make_str()
    }

    fun right_click(){
        if (check() == false) {
            showToast(this,"맞습니다.")
        }
        else {
            showToast(this,"틀렸습니다.")
            Vibration(1000)
        }
        make_str()
    }
}