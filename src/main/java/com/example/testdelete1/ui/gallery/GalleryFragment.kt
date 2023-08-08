package com.example.testdelete1.ui.gallery

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.testdelete1.R
import com.example.testdelete1.databinding.FragmentGalleryBinding
import com.example.testdelete1.ui.books.BooksActivity

class GalleryFragment : Fragment(),CategoryAdapter.CategoryListener {

    private lateinit var galleryViewModel: GalleryViewModel
    private var _binding: FragmentGalleryBinding? = null

    private lateinit var dialog: AlertDialog
    private lateinit var adapter: CategoryAdapter
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,

                savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        val recycler=binding.categoryRecycler
        initViews(recycler)

        galleryViewModel.categories.observe(viewLifecycleOwner, Observer {
            adapter=CategoryAdapter(context,it,this)
           recycler.adapter=adapter
            recycler.addItemDecoration(
                RecyclerDecoration(resources.getDimensionPixelSize(R.dimen.nav_header_vertical_spacing))
            )


        })
        val root: View = binding.root
//        val textView: TextView = binding.textGallery
   /*     galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }

    private fun initViews(recycler:RecyclerView) {

        dialog = AlertDialog.Builder(this.context).show()
        recycler.setHasFixedSize(true)

        val layoutManager=StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
        layoutManager.orientation=RecyclerView.VERTICAL
//        layoutManager.spanSizeLookup=object =GridLayoutManager.SpanSizeLookup
        recycler.layoutManager=layoutManager


    }

    override fun onClikc(adapterPosition: Int) {
        startActivity(Intent(activity,BooksActivity::class.java))

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}