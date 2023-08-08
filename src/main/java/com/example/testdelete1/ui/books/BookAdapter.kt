package com.example.bottomnewbest.recycler

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testdelete1.R
import com.example.testdelete1.models.Book
import com.example.testdelete1.models.JsonBook
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class BookAdapter(internal var context: Context?, internal var books: List<JsonBook>?,
                  val bookListener: BookListener?
)
    :RecyclerView.Adapter<BookAdapter.PopularViewHolder>() {
    val db = Firebase.firestore
    private val layoutInflater=LayoutInflater.from(context)
    class PopularViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener {
        private var book: Book? = null
        var book_image:ImageView?=null
        var book_title:TextView?=null
        var book_ratings:TextView?=null
         var listener:BookListener?=null
        init {
            book_image=itemView.findViewById(R.id.book_image) as ImageView
            book_title=itemView.findViewById(R.id.bookName_text)   as TextView
            book_ratings=itemView.findViewById(R.id.book_rating)   as TextView
            itemView.setOnClickListener(this)
        }
        fun bindView(bookListener: BookListener?, get: JsonBook?) {
            this.listener=bookListener!!
this.book=convertToBook(get)        }

        private fun convertToBook(response: JsonBook?): Book? {
                return Book(
                    response?.id!!,
                    response.name,
                    response.ratings,
                    response.imageUrl,
                    response.price,
                )

        }

        override fun onClick(p0: View?) {
            this.listener?.onClikc(adapterPosition,this.book)        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(layoutInflater.inflate(R.layout.popular_books_item,parent,false))
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        db.collection("books")
            .get()
            .addOnSuccessListener { result ->
                result.documents.forEach {
                    val bookImage = it.data!!.get("imageUrl")
                    val bookName = it.getString("name")
                    Log.d("TAG name", bookName.toString())
                    Log.d("TAG imgeURL", bookImage.toString())
                    Log.d("TAG equals touched", bookName.toString())
                    Glide.with(context!!).load(books?.get(position)?.imageUrl).into(holder.book_image!!)
                    holder.bindView(bookListener,books?.get(position))
                }
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }
//        Glide.with(context!!).load(books?.get(position)?.name)
        holder.book_title!!.setText(books?.get(position)?.name)
        holder.book_ratings!!.setText(books?.get(position)?.ratings.toString())

    }

    override fun getItemCount(): Int {
        return books!!.size
    }


    interface BookListener {
        fun onClikc(adapterPostion: Int, book: Book?)
    }


}