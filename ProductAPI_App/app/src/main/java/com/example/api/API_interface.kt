package com.example.api

import retrofit2.Call
import retrofit2.http.GET

interface API_interface {

    @GET("products")
    fun getProductdata():Call<MyData>
}