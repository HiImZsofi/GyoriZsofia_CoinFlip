package com.example.coinflip

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

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

    var isHead : Boolean = false
    var isTail : Boolean = false
    var throws : Int = 0
    var win : Int = 0
    var lose : Int = 0
    var rnd : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()



            guessHead.setOnClickListener{
                isHead = true
                throws++
                println(throws)
                rnd = (1..2).random()
                if(throws >= 5){
                    startOver()
                }
                else{
                    if(rnd == 1){
                        win++
                        image.setImageResource(R.drawable.heads)
                        guesses.setText("Dobások: " + throws.toString())
                        Toast.makeText(this@MainActivity, "A dobás értéke fej!", Toast.LENGTH_SHORT).show()
                        wins.setText("Győzelmek: " + win.toString())
                    }else if(rnd == 2){
                        lose++
                        image.setImageResource(R.drawable.tails)
                        guesses.setText("Dobások: " + throws.toString())
                        Toast.makeText(this@MainActivity, "A dobás értéke írás!", Toast.LENGTH_SHORT).show()
                        losses.setText("Vereségek: " + lose.toString())
                    }
                }
            }

            guessTail.setOnClickListener{
                isTail = true
                throws++
                println(throws)
                rnd = (1..2).random()
                if(throws >= 5){
                    startOver()
                }
                else{
                    if(rnd == 2){
                        win++
                        image.setImageResource(R.drawable.tails)
                        guesses.setText("Dobások: " + throws.toString())
                        Toast.makeText(this@MainActivity, "A dobás értéke írás!", Toast.LENGTH_SHORT).show()
                        wins.setText("Győzelmek: " + win.toString())
                    }else if(rnd == 1){
                        lose++
                        image.setImageResource(R.drawable.heads)
                        guesses.setText("Dobások: " + throws.toString())
                        Toast.makeText(this@MainActivity, "A dobás értéke fej!", Toast.LENGTH_SHORT).show()
                        losses.setText("Vereségek: " + lose.toString())
                    }
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

    fun startOver() {
        var gameOverDialogBuilder = AlertDialog.Builder(this@MainActivity)
        if(win > lose){
            gameOverDialogBuilder.setTitle("Győzelem!")
            gameOverDialogBuilder.setMessage("Szeretne új játékot játszani?")
            gameOverDialogBuilder.setCancelable(false)
            gameOverDialogBuilder.setNegativeButton("Nem", DialogInterface.OnClickListener {
                    dialog, id -> finish()
            })
            gameOverDialogBuilder.setPositiveButton("Igen", DialogInterface.OnClickListener {
                    dialog, id -> win = 0
                lose = 0
                throws = 0
                guesses.setText("Dobások: " + throws.toString())
                losses.setText("Vereségek: " + lose.toString())
                wins.setText("Győzelmek: " + win.toString())
                image.setImageResource(R.drawable.heads)
            })
            gameOverDialogBuilder.show()
        }
        else if(lose > win){
            gameOverDialogBuilder.setTitle("Vereség!")
            gameOverDialogBuilder.setMessage("Szeretne új játékot játszani?")
            gameOverDialogBuilder.setCancelable(false)
            gameOverDialogBuilder.setNegativeButton("Nem", DialogInterface.OnClickListener {
                    dialog, id -> finish()
            })
            gameOverDialogBuilder.setPositiveButton("Igen", DialogInterface.OnClickListener {
                    dialog, id -> win = 0
                lose = 0
                throws = 0
                guesses.setText("Dobások: " + throws.toString())
                losses.setText("Vereségek: " + lose.toString())
                wins.setText("Győzelmek: " + win.toString())
                image.setImageResource(R.drawable.heads)
            })
            gameOverDialogBuilder.show()
        }
    }
}