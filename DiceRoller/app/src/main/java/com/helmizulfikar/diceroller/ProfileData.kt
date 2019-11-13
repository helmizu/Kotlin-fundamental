package com.helmizulfikar.diceroller

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.helmizulfikar.diceroller.data.UserData
import com.helmizulfikar.diceroller.databinding.ProfileDataBinding

class ProfileData : AppCompatActivity() {

    private lateinit var binding: ProfileDataBinding

    private val userData: UserData = UserData("Helmi Zulfikar")

//    lateinit var inputNickname: EditText
//    lateinit var textNickname: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.profile_data)
        initLayout()
        initButton()
    }

    private fun initLayout() {
        // init screens binding
        binding = DataBindingUtil.setContentView(this, R.layout.profile_data)
        binding.userData = userData

//        inputNickname = findViewById(R.id.input_nickname)
//        textNickname = findViewById(R.id.text_nickname)
    }

    private fun initButton() {
//        findViewById<Button>(R.id.button_done).setOnClickListener {
//            addNickname(it)
//        }
        binding.buttonDone.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
//        view.visibility = View.GONE
//        inputNickname.visibility = View.GONE
//        textNickname.text = inputNickname.text
//        textNickname.visibility = View.VISIBLE

        // example binding to view
//        binding.buttonDone.visibility = View.GONE
//        binding.inputNickname.visibility = View.GONE
//        binding.textNickname.text = binding.inputNickname.text
//        binding.textNickname.visibility = View.VISIBLE

        // Best Practice
//        binding.apply {
//            buttonDone.visibility = View.GONE
//            inputNickname.visibility = View.GONE
//            textNickname.text = inputNickname.text
//            textNickname.visibility = View.VISIBLE
////            invalidateAll()
//        }

        // To Do 2, binding data value directly to screen
        binding.apply {
            buttonDone.visibility = View.GONE
            inputNickname.visibility = View.GONE
//            textNickname.text = inputNickname.text
            // change to this
            userData?.nickname = inputNickname.text.toString()
            textNickname.visibility = View.VISIBLE
            // Invalidate all binding expressions and request a new rebind to refresh
            invalidateAll() // used to recreated view, reset value on view
        }

        // Hide Keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}