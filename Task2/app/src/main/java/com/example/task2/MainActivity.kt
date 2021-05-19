package com.example.task2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() , BelowFragment.BelowFragmentListener {
    private val FragmentA = AboveFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.aboveFragmentFrame,FragmentA).commit()
    }

    override fun onBelowFragmentAddButtonPressed(value: String) {
        FragmentA.updateDataList(value)
    }

    override fun onBelowFragmentDeleteButtonPressed() {
        FragmentA.deleteEntry()
    }

    override fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }

}