package tn.rnu.isetr.guessing_numbers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b_mode : Button = findViewById(R.id.bmode)
        val e_mode : Button = findViewById(R.id.emode)


        b_mode.setOnClickListener(object : View.OnClickListener {
           override fun onClick(view: View){
               val intent = Intent(this@MainActivity, beginnermode::class.java)
               startActivity(intent)
           }
        })

        e_mode.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val intent2 = Intent(this@MainActivity, ExpertMode::class.java)
                startActivity(intent2)

            }
        })


    }
}