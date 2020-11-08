package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_easy.*
import java.util.*
import kotlin.concurrent.timer

class EasyActivity : AppCompatActivity() {

    //여기에 어떻게 해야할지 설계해야한다.
    var sToast: Toast? = null

    val odd = arrayOf(1,3,5,7,9)
    val even = arrayOf(2,4,6,8)

    val consonant = arrayOf("ㄱ","ㄴ","ㄷ","ㄹ","ㅁ","ㅂ","ㅅ","ㅇ","ㅈ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ")
    val vowel = arrayOf("ㅏ","ㅑ","ㅓ","ㅕ","ㅗ","ㅛ","ㅜ","ㅠ","ㅡ","ㅣ")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        var timer : Timer ? = null
        make_str()
        /*timer = timer(period = 3000){

            //sToast?.cancel()
        }
         */



    }

    fun Vibration(len: Long){
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(len)
    }

    fun make_str (){
        val random = Random()
        val num1 = random.nextInt(2)
        val num2 = random.nextInt(2)
        var str = ""

        if (num1 == 0)
            str += odd[random.nextInt(odd.size)]
        if (num1 == 1)
            str += even[random.nextInt(even.size)]
        if (num2 == 0)
            str += consonant[random.nextInt(consonant.size)]
        if (num2 == 1)
            str += vowel[random.nextInt(vowel.size)]

        val which = random.nextInt(2)
        val num4 = random.nextInt(2)

        if (num4 == 1 )
            str = str.reversed()

        if(which ==0) {
            view1.setText(str)
            view2.setText("")
        }
        else {
            view2.setText(str)
            view1.setText("")
        }
            //Toast.makeText(this, str, Toast.LENGTH_SHORT).show()자

    }


    fun showToast(context: Context?, message: String?) {
        if (sToast == null) {
            sToast = Toast.makeText(context, message, Toast.LENGTH_SHORT)

        } else {
            //sToast!!.cancel()
            sToast!!.setText(message)

        }
        sToast?.show()

    }

    fun btn_left (view: View){
        if (isCheck() == true){
            showToast(this,"정답입니다!.")
        }
        else {
            showToast(this,"오답입니다!.")
            Vibration(1000)
        }
        this.make_str();
    }
    fun btn_right(view : View){
        if (isCheck() == false){
            showToast(this,"정답입니다!.")
        }
        else {
            showToast(this,"오답입니다!.")
            Vibration(1000)
        }
        this.make_str();

    }


    fun isCheck(): Boolean {

        val str1 = view1.text
        val str2 = view2.text
        //val temp = str1.
        //str2
        println("start")
        println("str1: "+str1)
        println("str2:" +str2)
        //홀수를 판단하는 곳.
        if (str1 != "") {
            //Toast.makeText(this, (str1[0].toInt() % 2 == 1).toString(), Toast.LENGTH_SHORT).show()
            println(str1[0].toString())
            println(str1[1].toString())

            //숫자인지 아닌지를 판단하는 것이 필요하다.
            if (str1[0].isDigit())
                return str1[0].toInt() % 2 == 1
            else
                return str1[1].toInt() %2 == 1

        }
        //음을 판단하는 곳.
         else  {
             //Toast.makeText(this, (str2[1].toString() in vowel).toString(), Toast.LENGTH_SHORT).show()
             println(str2[1].toString())
             println(str2[0].toString())
             return str2[1].toString() in consonant || str2[0].toString() in consonant

         }

    }
}