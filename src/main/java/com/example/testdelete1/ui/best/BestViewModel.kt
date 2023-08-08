package com.example.bottomnewbest.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bottomnewbest.retrofit.ApiService
import com.example.bottomnewbest.retrofit.Repository
import com.example.testdelete1.models.JsonBook
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BestViewModel : ViewModel() {
    var books= ArrayList<JsonBook>()

    var data = MutableLiveData<List<JsonBook>>().apply {
        loadData()
    }

//    val text: LiveData<String> = _text

//best subcategory

    private fun loadData() {

        val service = ApiService.instance
        val repository = Repository(service)

        repository.getBestBooks().enqueue(object : Callback<List<JsonBook>> {

            override fun onResponse(
                call: Call<List<JsonBook>>,
                response: Response<List<JsonBook>>
            ) {
                data.value= response.body()

                Log.i("Response====", response.body()!!.toString())
                Log.i("books Response====", books.toString())
//                        text.setText(response.body()!!.name)
            }

            override fun onFailure(call: Call<List<JsonBook>>, t: Throwable) {
                Log.i("Error ===", t.message.toString())
//                books=null!!
            }

        })


    }
}