package com.example.task1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.dataModel.Exclusions
import com.example.task1.dataModel.Facilities
import com.example.task1.dataModel.Options


class FacilitiesAdapter(private val data: MutableList<Facilities>, private val exclude: MutableList<MutableList<Exclusions>>) :
    RecyclerView.Adapter<FacilitiesAdapter.ViewHolder>() {
    var selected : MutableMap<String,String> = mutableMapOf()
    lateinit  var radGrp : RadioGroup
    lateinit var ctx: Context
    lateinit var notFac : String
    lateinit var notOpt : String

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacilitiesAdapter.ViewHolder {
        ctx = parent.context
        val inflater = LayoutInflater.from(ctx)
        val view = inflater.inflate(R.layout.rad_grp_fragment, parent, false)
        radGrp = view.findViewById<RadioGroup>(R.id.radioGrp)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FacilitiesAdapter.ViewHolder, position: Int) {
        val textView = holder.facViewId
        textView.text = ("Facility Name -> " + data[position].name)
        addRadioButtons(data[position].options,ctx,data[position].facility_id)
    }

    override fun getItemCount(): Int = data.size

    fun addRadioButtons(opt: MutableList<Options>,ctx :Context,facId : String) {
        radGrp.orientation = LinearLayout.VERTICAL
        var pos = 0
        opt.forEach {
            val rdbtn = RadioButton(ctx)
            rdbtn.id = View.generateViewId()
            rdbtn.text = it.name +"      |      "+it.icon
            rdbtn.setPadding(100,0,0,0)
            rdbtn.setOnClickListener {itr ->
                val b = rdbtn.isChecked
                if(b)
                    selected[facId] = it.id
                else
                    selected.remove(facId,it.id)
                if(!validateClick()){
                    rdbtn.isChecked = false
                    selected.remove(facId,it.id)
                    Toast.makeText(ctx,"Not Allowed",Toast.LENGTH_SHORT).show()
                }
            }
            radGrp.addView(rdbtn)
            pos++
        }
    }


    fun validateClick() : Boolean {
        var count : Int = 0
        exclude.forEachIndexed { index, mutableList ->
            count = 0
            mutableList.forEachIndexed { index, exclusions ->
                if(selected[exclusions.facility_id] == exclusions.options_id)
                    count++
                if(count>1)
                    return false
            }
        }
        return true
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val facViewId = view.findViewById<TextView>(R.id.facilitiesTextView)
    }
}
