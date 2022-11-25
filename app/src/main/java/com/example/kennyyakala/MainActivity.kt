package com.example.kennyyakala

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var score = 0
    val kennyArray  = ArrayList<ImageView>()
    var handler = Handler()
    var runnable = Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kennyArray.add(imageViewKenny1)
        kennyArray.add(imageViewKenny2)
        kennyArray.add(imageViewKenny3)
        kennyArray.add(imageViewKenny4)
        kennyArray.add(imageViewKenny5)
        kennyArray.add(imageViewKenny6)
        kennyArray.add(imageViewKenny7)
        kennyArray.add(imageViewKenny8)
        kennyArray.add(imageViewKenny9)
        kennyArray.add(imageViewKenny10)
        kennyArray.add(imageViewKenny11)
        kennyArray.add(imageViewKenny12)
        kennyArray.add(imageViewKenny13)
        kennyArray.add(imageViewKenny14)
        kennyArray.add(imageViewKenny15)
        kennyArray.add(imageViewKenny16)

        kennySakla()






        //CountDown Timer

        object : CountDownTimer(15500,1000) {
            override fun onTick(p0: Long) {
                textViewTime.text = "ZAMAN: ${p0/1000}"
            }

            override fun onFinish() {
                textViewTime.text = "ZAMAN: 0"
                handler.removeCallbacks(runnable)
                for (image in kennyArray){
                    image.visibility = View.INVISIBLE
                }

                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Game Over")
                alert.setMessage("Baştan Başlamak İster misin ?")
                alert.setPositiveButton("EVET"){dialog, which ->
                    // oyunu bastan baslat
                    val intent = intent
                    finish()
                    startActivity(intent) // aktivitenin kendisini bastan başlatır.
                }
                alert.setNegativeButton("HAYIR"){dialog, which ->
                    Toast.makeText(this@MainActivity,"Game Over",Toast.LENGTH_SHORT).show()
                }
                alert.show()
            }
        }.start()

    }



    fun increaseScore(view: View){
        score++
        textViewSkor.text = "SKOR: ${score}"
    }

    fun kennySakla(){

        runnable = object  : Runnable{
            override fun run() {
                for(image in kennyArray){
                    image.visibility = View.INVISIBLE
                }

                val random  = java.util.Random()
                val randomIndex = random.nextInt(16)
                kennyArray[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable,500)
            }

        }
        handler.post(runnable)
    }

}