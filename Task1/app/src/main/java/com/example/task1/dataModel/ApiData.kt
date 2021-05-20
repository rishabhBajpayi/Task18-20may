package com.example.task1.dataModel

data class ApiData(var facilities: MutableList<Facilities>,var exclusions: MutableList<MutableList<Exclusions>> ){
    fun getFacilitiesId()  {
        var i = 0
        facilities.forEach {
            println(it)
            println(it.name)
            println(facilities[i].facility_id)
            i++
        }

    }
}

data class Facilities(var facility_id : String, var name : String, var options : MutableList<Options>)

data class Exclusions(var facility_id: String, var options_id : String)

data class Options(val id : String, var icon : String, var name : String)