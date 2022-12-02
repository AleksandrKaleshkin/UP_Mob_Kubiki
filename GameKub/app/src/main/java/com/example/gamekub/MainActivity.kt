package com.example.gamekub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button2)



        rollButton.setOnClickListener{
            rollDice()
            changePl()

        }

    }

    private fun changePl() {
        val player: TextView = findViewById(R.id.textView)
        if (player.text=="Игрок 1"){
            player.text="Игрок 2"
        }
        else if (player.text=="Игрок 2")
            player.text="Игрок 1"
        else
            player.text="Игрок 1"
    }

    private fun rollDice() {

        val dice = Dice(6)
        val kubRoll = dice.roll()
        val kubRoll2 = dice.roll()
        val resKub= kubRoll+kubRoll2

        val diceImage: ImageView = findViewById(R.id.imageView)
        val dice2Image: ImageView = findViewById(R.id.imageView2)



        when(kubRoll)
        {
            1 ->diceImage.setImageResource(R.drawable.dice_1)
            2 ->diceImage.setImageResource(R.drawable.dice_2)
            3 ->diceImage.setImageResource(R.drawable.dice_3)
            4 ->diceImage.setImageResource(R.drawable.dice_4)
            5 ->diceImage.setImageResource(R.drawable.dice_5)
            6 ->diceImage.setImageResource(R.drawable.dice_6)
        }

        when(kubRoll2)
        {
            1 ->dice2Image.setImageResource(R.drawable.dice_1)
            2 ->dice2Image.setImageResource(R.drawable.dice_2)
            3 ->dice2Image.setImageResource(R.drawable.dice_3)
            4 ->dice2Image.setImageResource(R.drawable.dice_4)
            5 ->dice2Image.setImageResource(R.drawable.dice_5)
            6 ->dice2Image.setImageResource(R.drawable.dice_6)
        }



    }

    class Dice(val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}