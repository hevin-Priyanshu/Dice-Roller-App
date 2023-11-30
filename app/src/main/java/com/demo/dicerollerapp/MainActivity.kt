package com.demo.dicerollerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var diceRolledBtn: Button
    private lateinit var resetBtn: Button
    private lateinit var imageDice: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceRolledBtn = findViewById(R.id.rolledBtn)
        imageDice = findViewById(R.id.imageDemo)
        resetBtn = findViewById(R.id.resetBtn)

        diceRolledBtn.setOnClickListener {
            val dice = Dice(6)
            val random = dice.roll()


            when (random) {
                1 -> imageDice.setImageResource(R.drawable.dice_six_faces_one)

                2 -> imageDice.setImageResource(R.drawable.dice_six_faces_two)

                3 -> imageDice.setImageResource(R.drawable.dice_six_faces_three)

                4 -> imageDice.setImageResource(R.drawable.dice_six_faces_four)

                5 -> imageDice.setImageResource(R.drawable.dice_six_faces_five)

                6 -> imageDice.setImageResource(R.drawable.dice_six_faces_six)
            }

            Toast.makeText(this, "Dice Rolled -> $random", Toast.LENGTH_SHORT).show()
        }

        resetBtn.setOnClickListener {
            imageDice.setImageResource(R.drawable.demo)
            Toast.makeText(this, "Dice Reset", Toast.LENGTH_SHORT).show()
        }
    }


    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}