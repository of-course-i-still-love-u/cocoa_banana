package com.example.justretrofit

import retrofit2.Call
import retrofit2.http.GET

interface FetchApi {
    @GET("agents")
    fun getAgent():Call<MutableList<Agents>>
}

