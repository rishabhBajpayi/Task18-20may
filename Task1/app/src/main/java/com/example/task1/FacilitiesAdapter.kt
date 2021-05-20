package com.example.task1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.dataModel.Facilities
import com.example.task1.dataModel.Options

class FacilitiesAdapter(private val data: MutableList<Facilities>) :
    RecyclerView.Adapter<FacilitiesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacilitiesAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.facilities_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FacilitiesAdapter.ViewHolder, position: Int) {
        val textView = holder.facViewId
        textView.setText("Facility Name -> " + data[position].name)
        val rvOpt = holder.optRvId
        val adapter = OptionsAdapter(data[position].options)
        rvOpt.adapter = adapter
        rvOpt.layoutManager = LinearLayoutManager(rvOpt.context)
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val facViewId = view.findViewById<TextView>(R.id.facilitiesTextView)
        val optRvId = view.findViewById<RecyclerView>(R.id.optionsRecyclerView)
    }
}
