package com.helmizulfikar.diceroller

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Profile : AppCompatActivity() {

    lateinit var inputNickname: EditText
    lateinit var textNickname: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)
        initLayout()
        initButton()
    }

    private fun initLayout() {
        inputNickname = findViewById(R.id.input_nickname)
        textNickname = findViewById(R.id.text_nickname)
    }

    private fun initButton() {
        findViewById<Button>(R.id.button_done).setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        view.visibility = View.GONE
        inputNickname.visibility = View.GONE
        textNickname.text = inputNickname.text
        textNickname.visibility = View.VISIBLE

        // Hide Keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}