package com.example.testdelete1.ui.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bottomnewbest.retrofit.Repository
import com.example.testdelete1.models.Category
import com.example.testdelete1.models.JsonBook
import retrofit2.Response

class BookViewModel(private val repo: Repository): ViewModel() {

    val apiResponse:MutableLiveData<Response<List<JsonBook>>> = MutableLiveData()


}/*
    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text*/


/*  init {
      categoryList.addAll(

          listOf(Category("Fiction"),Category("Horror"))

      )
  }*/


