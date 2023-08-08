package com.example.testdelete1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testdelete1.R
import com.example.testdelete1.cardHelper.CardBookAdapter
import com.example.testdelete1.cardHelper.ManagementCard
import com.example.testdelete1.ui.order.OrderActivity

class CartActivity : AppCompatActivity() {
   private lateinit var  checkoutBtn: TextView;
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CardBookAdapter
    private lateinit var scrollView: ScrollView
    private lateinit var card:ManagementCard
    private lateinit var total:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        checkoutBtn=findViewById(R.id.order_checkout)
        scrollView=findViewById(R.id.cart_scrollView)
        recyclerView=findViewById(R.id.cart_items_recycler)
        total=findViewById(R.id.totalTxt)
        checkoutBtn.setOnClickListener({
            startActivity(Intent(this, OrderActivity::class.java))
        })
initList()
        var totalValue=calculateTotal()
        total.setText("$"+totalValue)
}

    private fun initList() {
        var lineralayoutManager:LinearLayoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
recyclerView.layoutManager=lineralayoutManager
        adapter= CardBookAdapter(this,card.getBooks())
        recyclerView.adapter=adapter

    }
    fun calculateTotal():Double{
        var total:Double= Math.round(card.getTotal()).toDouble()
return total
    }
}