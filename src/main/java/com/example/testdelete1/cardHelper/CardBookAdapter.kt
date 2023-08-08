package com.example.testdelete1.cardHelper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testdelete1.R
import com.example.testdelete1.models.Book
import com.example.testdelete1.models.Category

class CardBookAdapter(internal var context: Context?, internal var books: List<Book>
)
    :RecyclerView.Adapter<CardBookAdapter.BookViewModel>() {


    private val layoutInflater=LayoutInflater.from(context)
    class BookViewModel(itemView: View):RecyclerView.ViewHolder(itemView) {
        //         var category_image:CircleImageView?=null
        var book_title:TextView?=null
        var book_price:TextView?=null
        var book_image:ImageView?=null


        init {

            book_image=itemView.findViewById(R.id.cart_book_image)   as ImageView
            book_price=itemView.findViewById(R.id.cart_book_price)   as TextView
            book_title=itemView.findViewById(R.id.cart_book_name)   as TextView

        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewModel {
        return BookViewModel(layoutInflater.inflate(R.layout.card_row,parent,false))
    }


    override fun getItemCount(): Int {
        return books.size
    }



    override fun onBindViewHolder(holder: CardBookAdapter.BookViewModel, position: Int) {
        holder.book_title!!.setText(books[position].name)
        holder.book_price!!.setText(books[position].price.toString())
        Glide.with(context!!).load(books?.get(position)?.imageUrl).into(holder.book_image!!)



    }}

