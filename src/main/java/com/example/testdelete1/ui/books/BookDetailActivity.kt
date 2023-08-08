package com.example.testdelete1.ui.books

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bottomnewbest.recycler.BookAdapter
import com.example.testdelete1.R
import com.example.testdelete1.cardHelper.ManagementCard
import com.example.testdelete1.databinding.FragmentNewBinding
import com.example.testdelete1.models.Book
import com.example.testdelete1.ui.CartActivity
import com.example.testdelete1.ui.home.HomeFragment
import com.example.testdelete1.ui.newfragment.NewViewModel
import com.example.testdelete1.ui.order.OrderActivity

class BookDetailActivity : AppCompatActivity() {

    private lateinit var  checkoutbtn:ImageView;
    private lateinit var  bookImage:ImageView;
    private lateinit var  bookRating:TextView;
    private lateinit var  bookName:TextView;
    private lateinit var  addToCart:ImageView;
    lateinit var card: ManagementCard

lateinit var book: Book
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)
    bookName=findViewById(R.id.book_detail_name)
    bookRating=findViewById(R.id.book_detail_rating)
    bookImage=findViewById(R.id.book_detail_image)
    checkoutbtn=findViewById(R.id.detail_checkout_button)
        checkoutbtn.setOnClickListener({
//            Toast.makeText(this,"book recieved"+book.name,Toast.LENGTH_LONG).show()

            startActivity(Intent(this,OrderActivity::class.java))
        })

         addToCart=findViewById(R.id.checkout)
        addToCart.setOnClickListener({
//            startActivity(Intent(this,CartActivity::class.java))
            Toast.makeText(this,""+book.name+" addded to cart",Toast.LENGTH_LONG).show()
//            this.card.inserBook(book)
        })

        book= intent.getParcelableExtra(HomeFragment.INTENT_BOOK_KEY)!!
        Glide.with(this).load(book.imageUrl).into(bookImage)
        bookName.text=book.name
        bookRating.text=book.ratings.toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}
