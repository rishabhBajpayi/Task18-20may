package com.example.task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView


class ComponentAdapter(private val data: MutableList<String>) :
    RecyclerView.Adapter<ComponentAdapter.ViewHolder>() {

    var remList: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.above_fragment_component, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComponentAdapter.ViewHolder, position: Int) {
        val checkBoxview = holder.compId
        checkBoxview.setText(data[position])
        checkBoxview.setOnCheckedChangeListener { compoundButton, b ->
            println(remList)
            if (b) {
                remList.add(checkBoxview.text.toString())
            } else {
                remList.removeIf { it == checkBoxview.text.toString() }
            }
//            println(remList)
//            println(checkBoxview.text.toString()+ " is checked $b")
        }
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val compId = view.findViewById<CheckBox>(R.id.checkboxComp)
    }
}
