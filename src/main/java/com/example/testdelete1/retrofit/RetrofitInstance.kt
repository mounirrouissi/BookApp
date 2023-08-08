package com.example.bottomnewbest.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitInstance {





        private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(Constants.books_URl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

