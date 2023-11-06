package com.example.justretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private val BASE_URL = "https://valorant-api.com/v1/"
    private val BASE_URL2 = "https://jsonplaceholder.typicode.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAllAgents()
    }

    private  fun getAllAgents (){
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FetchApi::class.java)

        api.getAgent().enqueue(object:Callback<MutableList<Agents>>{
            override fun onResponse(
                call: Call<MutableList<Agents>>,
                response: Response<MutableList<Agents>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        for (agents in it){
                            Log.d("=====>","response = "+it)
                        }
                    }
                }

            }

            override fun onFailure(call: Call<MutableList<Agents>>, t: Throwable) {
                Log.d("=====>","response error = "+t.message)
            }

        })
    }
}