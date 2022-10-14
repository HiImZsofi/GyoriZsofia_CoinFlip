package com.example.coinflip

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var rlayout : RelativeLayout
    private lateinit var lnlayout : LinearLayout
    private lateinit var image : ImageView
    private lateinit var btnlayout : LinearLayout
    private lateinit var guessHead : Button
    private lateinit var guessTail : Button
    private lateinit var guesses : TextView
    private lateinit var wins : TextView
    private lateinit var losses : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        var isHead : Boolean = false
        var isTail : Boolean = false
        var throws : Int = 0
        var win : Int = 0
        var lose : Int = 0
        var rnd : Int = 0
        guessHead.setOnClickListener{
            isHead = true
            throws++
            rnd = (1..2).random()
            if(rnd == 1){
                win++
                image.setImageResource(R.drawable.heads)
                guesses.setText("Dobások: " + throws.toString())
                Toast.makeText(this@MainActivity, "A dobás értéke fej!", Toast.LENGTH_SHORT).show()
                wins.setText("Győzelmek: " + win.toString())
            }else{
                lose++
                image.setImageResource(R.drawable.tails)
                guesses.setText("Dobások: " + throws.toString())
                Toast.makeText(this@MainActivity, "A dobás értéke írás!", Toast.LENGTH_SHORT).show()
                losses.setText("Vereségek: " + lose.toString())
            }
        }

        guessTail.setOnClickListener{
            isTail = true
            throws++
            rnd = (1..2).random()
            if(rnd == 2){
                win++
                image.setImageResource(R.drawable.heads)
                guesses.setText("Dobások: " + throws.toString())
                Toast.makeText(this@MainActivity, "A dobás értéke írás!", Toast.LENGTH_SHORT).show()
                wins.setText("Győzelmek: " + win.toString())
            }else{
                lose++
                image.setImageResource(R.drawable.tails)
                guesses.setText("Dobások: " + throws.toString())
                Toast.makeText(this@MainActivity, "A dobás értéke fej!", Toast.LENGTH_SHORT).show()
                losses.setText("Vereségek: " + lose.toString())
            }
        }

    }

    fun init(){
        rlayout = findViewById(R.id.rlayout)
        lnlayout = findViewById(R.id.lnlayout)
        image = findViewById(R.id.image)
        btnlayout = findViewById(R.id.btnlayout)
        guessHead = findViewById(R.id.guessHead)
        guessTail = findViewById(R.id.guessTail)
        guesses = findViewById(R.id.guesses)
        wins = findViewById(R.id.wins)
        losses = findViewById(R.id.losses)
    }
}