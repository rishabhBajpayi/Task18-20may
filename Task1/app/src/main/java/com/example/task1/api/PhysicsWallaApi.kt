package com.example.task1.api

import com.example.task1.dataModel.ApiData
import retrofit2.Call
import retrofit2.http.GET

interface PhysicsWallaApi {

    @GET("/ricky1550/pariksha/db")
    fun getPosts(): Call<ApiData>
}