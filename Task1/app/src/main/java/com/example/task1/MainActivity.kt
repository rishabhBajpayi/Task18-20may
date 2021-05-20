package com.example.task1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.api.PhysicsWallaApi
import com.example.task1.api.ServiceGenerator
import com.example.task1.dataModel.ApiData
import com.example.task1.dataModel.Facilities
import retrofit2.*

class MainActivity : AppCompatActivity() {
    var data: MutableList<Facilities> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceGenerator = ServiceGenerator.buildService(PhysicsWallaApi::class.java)
        val call = serviceGenerator.getPosts()
        call.enqueue(object : Callback<ApiData> {
            override fun onFailure(call: Call<ApiData>, t: Throwable) {
                t.printStackTrace()
                println(t.message.toString())
            }
            override fun onResponse(call: Call<ApiData>, response: Response<ApiData>) {
                if (response.isSuccessful) {
                    data = response.body()?.facilities!!
                    val rvFac = findViewById<View>(R.id.facilitiesRecyclerView) as RecyclerView
                    val adapter = FacilitiesAdapter(data)
                    rvFac.adapter = adapter
                    rvFac.layoutManager = LinearLayoutManager(baseContext)
                }
            }
        })
    }
}