package com.helmizulfikar.diceroller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var rollButton: Button
    private lateinit var aboutMeButton: Button
    private lateinit var resultText: TextView
    private lateinit var diceImage: ImageView
    private lateinit var dataBindingButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initLayout()
        initButtonFunction()
    }

    private fun initLayout () {
        rollButton = findViewById(R.id.roll_button)
        resultText = findViewById(R.id.result_text)
        diceImage = findViewById(R.id.dice_image)
        aboutMeButton = findViewById(R.id.about_me_button)
        dataBindingButton = findViewById(R.id.data_binding_button)
    }

    private fun initButtonFunction () {
        rollButton.text = "Let's Roll"
        rollButton.setOnClickListener {
            rollDice()
        }
        aboutMeButton.setOnClickListener {
            val intentAboutMe = Intent(this, Profile::class.java)
            startActivity(intentAboutMe)
            Toast.makeText(this, "Routed", Toast.LENGTH_SHORT).show()
        }
        dataBindingButton.setOnClickListener {
            val intentDataBinding = Intent(this, ProfileData::class.java)
            startActivity(intentDataBinding)
            Toast.makeText(this, "Routed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        val imageSrc = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        diceImage.setImageResource(imageSrc)
        resultText.text = randomInt.toString()
        rollButton.text = "Roll Again"
    }
}
