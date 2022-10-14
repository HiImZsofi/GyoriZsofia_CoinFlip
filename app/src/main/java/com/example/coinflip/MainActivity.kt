package com.example.coinflip

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