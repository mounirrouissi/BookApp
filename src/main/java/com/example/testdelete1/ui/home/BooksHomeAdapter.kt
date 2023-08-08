package com.example.testdelete1.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testdelete1.R
import com.example.testdelete1.models.Author
import com.example.testdelete1.models.Book


class BooksHomeAdapter(internal var context: Context?, internal var books: List<Book>, internal var authors: ArrayList<Author>?,
                       val bookListener: BookListener?
)
    :RecyclerView.Adapter<BooksHomeAdapter.BookViewModel>() {


    private val layoutInflater=LayoutInflater.from(context)
    class BookViewModel(itemView: View):RecyclerView.ViewHolder(itemView) ,View.OnClickListener{
        //         var category_image:CircleImageView?=null
        lateinit var  listener:BookListener
        var bookName:TextView?=null
        var bookAuthors:TextView?=null


        init {

//    category_image=itemView.findViewById(R.id.popular_category_image) as CircleImageView
            bookName=itemView.findViewById(R.id.bookName_text)   as TextView
            bookAuthors=itemView.findViewById(R.id.bookAuthors_text)   as TextView
            itemView.setOnClickListener(this)

        }

        override fun onClick(p0: View?) {
            listener.onClikc(adapterPosition)
        }

        fun bindView(bookListener: BookListener?) {
            this.listener=bookListener!!
        }
    }

    interface BookListener {
        fun onClikc(adapterPostion:Int)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewModel {
        return BookViewModel(layoutInflater.inflate(R.layout.book_item,parent,false))
    }

    override fun onBindViewHolder(holder: BookViewModel, position: Int) {
//    Glide.with(context!!).load(categories[position].cover).into(holder.category_image!!)
        holder.bookName!!.setText(books[position].name)
//        holder.bookAuthors!!.setText(books[position].authors.toString())
        holder.bindView(bookListener)
    }

    override fun getItemCount(): Int {
        return books.size
    }

}

