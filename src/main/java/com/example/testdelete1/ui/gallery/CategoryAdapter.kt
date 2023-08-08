package com.example.testdelete1.ui.gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testdelete1.R
import com.example.testdelete1.models.Category

class CategoryAdapter(internal var context: Context?, internal var categories: List<Category>,
                      val categoryListener: CategoryListener?
)
    :RecyclerView.Adapter<CategoryAdapter.CategoryViewModel>() {


private val layoutInflater=LayoutInflater.from(context)
     class CategoryViewModel(itemView: View):RecyclerView.ViewHolder(itemView) ,View.OnClickListener{
//         var category_image:CircleImageView?=null
lateinit var  listener:CategoryListener
         var category_title:TextView?=null


         init {

//    category_image=itemView.findViewById(R.id.popular_category_image) as CircleImageView
     category_title=itemView.findViewById(R.id.category_name)   as TextView
         category_title!!.setOnClickListener(this)

}

         override fun onClick(p0: View?) {
             listener.onClikc(adapterPosition)
         }

         fun bindView(categoryListener: CategoryListener?) {
             this.listener=categoryListener!!
         }
     }

    interface CategoryListener {
        fun onClikc(adapterPostion:Int)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewModel {
        return CategoryViewModel(layoutInflater.inflate(R.layout.category_item,parent,false))
    }

    override fun onBindViewHolder(holder: CategoryViewModel, position: Int) {
//    Glide.with(context!!).load(categories[position].cover).into(holder.category_image!!)
        holder.category_title!!.setText(categories[position].name)
        holder.bindView(categoryListener)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

}

