package com.example.task2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import java.lang.RuntimeException

class BelowFragment : Fragment() {

    lateinit var listener: BelowFragmentListener

    companion object {
        fun newInstance(): BelowFragment {
            return BelowFragment()
        }
    }

    interface BelowFragmentListener {
        fun onBelowFragmentAddButtonPressed(value: String)
        fun onBelowFragmentDeleteButtonPressed()
        fun handleKeyEvent(view: View,keyEvent: Int) : Boolean
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.below_fragment, container, false)
        val editText = view.findViewById<EditText>(R.id.addValue)
        val addBtn = view.findViewById<Button>(R.id.addBtn)
        val delBtn = view.findViewById<Button>(R.id.delBtn)
        var text = editText.text
        addBtn.setOnClickListener {
            println(text)
            if(text.toString().isNotEmpty())
                listener.onBelowFragmentAddButtonPressed(text.toString())
            else
                Log.i("Name","isEmpty")
        }
        delBtn.setOnClickListener {
            listener.onBelowFragmentDeleteButtonPressed()
        }
        editText.setOnKeyListener{ view, keyCode, _ ->
            listener.handleKeyEvent(view, keyCode)
        }
        view.findViewById<Button>(R.id.addBtn)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is BelowFragmentListener){
            listener = context
        }
        else{
            throw RuntimeException(context.toString()+"must implement BelowFragmentLListener ")
        }
    }

}