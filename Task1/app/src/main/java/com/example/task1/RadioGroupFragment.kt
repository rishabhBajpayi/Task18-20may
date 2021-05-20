package com.example.task1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment


class RadioGroupFragment() : Fragment() {
    var data: MutableList<String> = mutableListOf("Rome", "Italy", "Varanasi", "Moscow")
    lateinit  var radGrp : RadioGroup

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.rad_grp_fragment, container, false)
        radGrp = view.findViewById<RadioGroup>(R.id.radioGrp)
        val activity = activity as Context
        addRadioButtons(3,activity)
        return view
    }

    fun addRadioButtons(number: Int,ctx :Context) {
        radGrp.setOrientation(LinearLayout.VERTICAL)
        for (i in 1..number) {
            val rdbtn = RadioButton(ctx)
            rdbtn.id = View.generateViewId()
            rdbtn.text = "Radio " + rdbtn.id
//            rdbtn.setOnClickListener(this)
            radGrp.addView(rdbtn)
        }
    }
}