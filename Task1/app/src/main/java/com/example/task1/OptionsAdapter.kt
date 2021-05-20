package com.example.task1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.dataModel.Options


class OptionsAdapter(private val data: MutableList<Options>) :
    RecyclerView.Adapter<OptionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.options_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: OptionsAdapter.ViewHolder, position: Int) {
        val textView = holder.optViewId
        val radBtn = holder.optRadBtn
        textView.setText(data[position].icon)
        radBtn.setText(data[position].name)
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val optViewId = view.findViewById<TextView>(R.id.optionsTextView)
        val optRadBtn = view.findViewById<RadioButton>(R.id.radBtn)
    }
}
