package tn.rnu.isetr.guessing_numbers

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import kotlin.random.Random

class beginnermode : AppCompatActivity() {
    lateinit var hint : TextView
    lateinit var input : EditText
    lateinit var enter : Button
    lateinit var historyListView: ListView
    lateinit var again: ImageView

    val guessHistory = ArrayList<String>()


    var random_number : Int = Random.nextInt(1, 10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beginnermode)

        hint = findViewById(R.id.hint)
        input = findViewById(R.id.editext)
        enter = findViewById(R.id.enter)
        historyListView = findViewById(R.id.historyListView)
        again =  findViewById(R.id.again)




        enter.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {

                val num : Int = input.text.toString().toInt()
                var history_hint : String = ""
                if(num < random_number) {
                    hint.text = "Your entred number is low"
                    input.text.clear()
                    history_hint = "Low"


                } else if (num > random_number) {
                    hint.text = "Your entred number is high"
                    input.text.clear()
                    history_hint = "High"

                } else {
                    hint.text = "Congrates 🎊 ! You guessed it right, the number is $random_number"
                    input.text.clear()
                    history_hint = "Correct"


                }

                // Add the guess to the history
                guessHistory.add("$num - $history_hint")

                // Update the ListView to display the history
                val adapter = ArrayAdapter(this@beginnermode, R.layout.list_item_layout, guessHistory)
                historyListView.adapter = adapter

                input.text.clear()


            }
        })

        /******************************/

        again.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                try_again()
            }
        })

    }

    fun try_again() {
        random_number = Random.nextInt(1, 10)
        hint.text = "Waiting.."
        input.text.clear()
        guessHistory.clear()

    }
}