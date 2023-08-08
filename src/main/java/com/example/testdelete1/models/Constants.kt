package com.example.testdelete1.models

import com.example.testdelete1.R

class Constants {
    companion object{
        const val books_URl="https://mybookstorewebsite.herokuapp.com/"
        fun getAvenger(): MutableList<BooksBanner> {
            val items = mutableListOf<BooksBanner>()
            items.add(BooksBanner("7.1", R.drawable.library))
            items.add(BooksBanner("9.2", R.drawable.library2))
            items.add(BooksBanner("7.5", R.drawable.library3))
            items.add(BooksBanner("7.9", R.drawable.library2))
            return items
        }
    }
}