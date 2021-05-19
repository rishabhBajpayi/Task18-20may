package com.example.task2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AboveFragment() : Fragment() {
    var data: MutableList<String> = mutableListOf("Rome", "Italy", "Varanasi", "Moscow")
    private lateinit var adapter: ComponentAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.above_fragment, container, false)
        val activity = activity as Context
        recyclerView = view.findViewById<RecyclerView>(R.id.fragmentRecycleView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = ComponentAdapter(data)
        recyclerView.adapter = adapter
        return view
    }

    fun updateDataList(value: String) {
        data.add(value)
        adapter.notifyDataSetChanged()
    }

    fun deleteEntry() {
//        println("data entry $data")
        data.removeAll(adapter.remList)
        adapter.remList.clear()
        recyclerView.removeAllViews()
        adapter.notifyDataSetChanged()
//        println(adapter.remList)
    }

}