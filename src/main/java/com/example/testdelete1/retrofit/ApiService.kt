package com.example.bottomnewbest.retrofit


import com.example.testdelete1.models.Category
import com.example.testdelete1.models.JsonBook
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    companion object {
        // 4
        val instance : ApiService by lazy {
            // 5
            val retrofit = Retrofit.Builder()
                .baseUrl("https://mybookstorewebsite.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(ApiService::class.java)

        }
    }
    @GET("/category/1")
         fun getCategories(): Call<List<Category>>

     @GET("/categories/{id}/books")
     fun getBooksByCategory(@Path("id") categoryId:Long): Call<List<JsonBook>>

@GET("/books/search")
     fun  searchByText(@Query("text") text:String): Call<List<JsonBook>>



    @GET("/category/{id}/bestseller")
     fun getBestBooksByCategoryId(@Path("id")id:Long): Call<List<JsonBook>>


    @GET("/category/{id}/latest")
    fun getNewBooksByCategoryId(@Path("id")id:Long): Call<List<JsonBook>>
        // 1
}