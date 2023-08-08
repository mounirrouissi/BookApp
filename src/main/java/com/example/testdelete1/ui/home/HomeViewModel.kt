package com.example.testdelete1.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bottomnewbest.retrofit.ApiService
import com.example.bottomnewbest.retrofit.Repository
import com.example.testdelete1.models.Author
import com.example.testdelete1.models.Book
import com.example.testdelete1.models.Category
import com.example.testdelete1.models.JsonBook
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class HomeViewModel : ViewModel() {

    var bestsellers = MutableLiveData<List<JsonBook>>().apply {
        loadBest()
    }
    var featured = MutableLiveData<List<JsonBook>>().apply {
        loadFeatured()
    }


      val text=MutableLiveData<List<Category>>().apply {
        value= listOf(
            Category("Fiction"), Category("Horror"),
            Category("Non-fiction"), Category("Others"),

            )

    }
 /*     val books=MutableLiveData<List<Book>>().apply {
        value= listOf(
            Book(2L,"Kloi",1.0, listOf(Author(1L,"Slim")),10.00,"..","https://firebasestorage.googleapis.com/v0/b/bookstore-4337f.appspot.com/o/b%20(6).jpg?alt=media&token=baa3adf9-dd6f-4bea-852a-5eb12f0236f1", Date(2020)),
            Book(1L,"fe",1.0, listOf(Author(1L,"Slim")),10.00,"..","https://firebasestorage.googleapis.com/v0/b/bookstore-4337f.appspot.com/o/b%20(6).jpg?alt=media&token=baa3adf9-dd6f-4bea-852a-5eb12f0236f1", Date(2020)),
            Book(3L,"sd",1.0, listOf(Author(1L,"Slim")),10.00,"..","https://firebasestorage.googleapis.com/v0/b/bookstore-4337f.appspot.com/o/b%20(6).jpg?alt=media&token=baa3adf9-dd6f-4bea-852a-5eb12f0236f1", Date(2020)),

        )
    }*/
    private fun loadBest() {

        val service = ApiService.instance
        val repository = Repository(service)

        repository.getBestBooks().enqueue(object : Callback<List<JsonBook>> {

            override fun onResponse(
                call: Call<List<JsonBook>>,
                response: Response<List<JsonBook>>
            ) {
                bestsellers.value= response.body()

                Log.i("Response====", response.body()!!.toString())
//                Log.i("books Response====", books.toString())
//                        text.setText(response.body()!!.name)
            }

            override fun onFailure(call: Call<List<JsonBook>>, t: Throwable) {
                Log.i("Error ===", t.message.toString())
//                books=null!!
            }

        })


    }

    private fun loadFeatured()  {

        val service = ApiService.instance
        val repository = Repository(service)

        repository.getBooks().enqueue(object : Callback<List<JsonBook>> {

            override fun onResponse(
                call: Call<List<JsonBook>>,
                response: Response<List<JsonBook>>
            ) {
                featured.value= response.body()

                Log.i("Response====", response.body()!!.toString())
//                Log.i("books Response====", books.toString())
//                        text.setText(response.body()!!.name)
            }

            override fun onFailure(call: Call<List<JsonBook>>, t: Throwable) {
                Log.i("Error ===", t.message.toString())
//                books=null!!
            }

        })


    }


}