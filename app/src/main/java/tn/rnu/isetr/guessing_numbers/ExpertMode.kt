package tn.rnu.isetr.guessing_numbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.view.View
import android.widget.*
import kotlin.random.Random

class ExpertMode : AppCompatActivity() {

    lateinit var hint : TextView
    lateinit var input : EditText
    lateinit var enter : Button
    lateinit var again: ImageView
    lateinit var chronometer: Chronometer
    lateinit var chrono: TextView


    var random_number : Int = Random.nextInt(1, 10)
    var timer: CountDownTimer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expert_mode)

        hint = findViewById(R.id.hint2)
        input = findViewById(R.id.editext2)
        enter = findViewById(R.id.enter2)
        again =  findViewById(R.id.again2)
        chronometer = findViewById(R.id.chronometer)
        chrono = findViewById(R.id.chrono)


        enter.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {

                val num : Int = input.text.toString().toInt()
                if(num < random_number) {
                    hint.text = "Your entred number is low"
                    input.text.clear()


                } else if (num > random_number) {
                    hint.text = "Your entred number is high"
                    input.text.clear()

                } else {
                    hint.text = "Congrates 🎊 ! You guessed it right, the number is $random_number"
                    input.text.clear()
                    timer?.cancel()

                }


            }
        })

        /******************************/

        again.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                try_again()

            }
        })

        start_chronometre()



    }

    fun try_again() {
        random_number = Random.nextInt(1, 10)
        hint.text = "Waiting.."
        input.text.clear()

        start_chronometre()
    }

/******************************/
    fun start_chronometre() {
        if (timer != null){
           timer?.cancel()
        }
        timer = object : CountDownTimer(20000, 1000) {
            override fun onTick(milli_seconds: Long) {
                val seconds_rest = milli_seconds / 1000
                chrono.text = "$seconds_rest"
            }

            override fun onFinish() {
                hint.text = "You failed to guess. Please try again"
            }
        }.start()

        // Start the Chronometer when the timer starts
        chronometer.base = SystemClock.elapsedRealtime()
        chronometer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}