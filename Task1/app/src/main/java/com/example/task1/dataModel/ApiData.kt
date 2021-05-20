package com.example.task1.dataModel

data class ApiData(var facilities: MutableList<Facilities>,var exclusions: MutableList<MutableList<Exclusions>> )

data class Facilities(var facility_id : String, var name : String, var options : MutableList<Options>)

data class Exclusions(var facility_id: String, var options_id : String)

data class Options(val id : String, var icon : String, var name : String)