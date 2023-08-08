package com.example.testdelete1.cardHelper

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.project531.Helper.TinyDB
import com.example.testdelete1.models.Book

class ManagementCard(var contect: Context,var tinyDB: TinyDB) {


    fun inserBook(book: Book){
        var listBook=getBooks   ()
        Log.d("BOOK TO insert","=="+book)
        var existsAlready: Boolean=false

        var n=0;
        for(i in 0..listBook.size){
            if (listBook.get(i).name.equals(book.name))
            {
                existsAlready = true
                n = i;
                break
            }
            if(existsAlready){
                TODO()
            }else{
                listBook.add(book)
            }
            tinyDB.putListObject("CardBooks",listBook)
            Toast.makeText(this.contect,"book added",Toast.LENGTH_LONG).show()
        }
    }

     fun getBooks(): ArrayList<Book> {
return tinyDB.getListObject("CardBooks")
    }
    fun getTotal():Double{
        var listBooks2=getBooks()
        var fee:Double= 0.0
        for(i in 0..listBooks2.size) {
        fee=fee+listBooks2.get(i).price
        }
        return fee
    }


    }
