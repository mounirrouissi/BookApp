package com.example.testdelete1.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testdelete1.models.Category

class GalleryViewModel : ViewModel() {
private  val categoryList=MutableLiveData<List<Category>>().apply {
    value= listOf(
        Category("Fiction"),
        Category("Non-fiction"),Category("Others"),

        )

}/*
    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text*/
    val  categories =categoryList

/*  init {
      categoryList.addAll(

          listOf(Category("Fiction"),Category("Horror"))

      )
  }*/


}