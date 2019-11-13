package com.helmizulfikar.learnconstraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews : List<View> = listOf(box_one, box_two, box_three, box_four, box_five, constrains_wrapper)

        for (item in clickableViews) {
            item.setOnClickListener{ changeColor(it) }
        }
    }

    private fun changeColor(view: View) {
        when (view.id) {
            R.id.box_one -> view.setBackgroundResource(android.R.color.holo_blue_dark)
            R.id.box_two -> view.setBackgroundResource(android.R.color.holo_red_dark)
            R.id.box_three -> view.setBackgroundResource(android.R.color.holo_purple)
            R.id.box_four -> view.setBackgroundResource(android.R.color.holo_orange_dark)
            R.id.box_five -> view.setBackgroundResource(android.R.color.holo_green_dark)
            else -> view.setBackgroundResource(android.R.color.darker_gray)
        }
    }
}
