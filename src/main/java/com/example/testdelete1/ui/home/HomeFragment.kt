package com.example.testdelete1.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnewbest.recycler.BookAdapter
import com.example.testdelete1.databinding.FragmentHomeBinding
import com.example.testdelete1.models.Book
import com.example.testdelete1.ui.books.BookDetailActivity
import com.smarteist.autoimageslider.SliderView

class HomeFragment : Fragment(),BooksHomeAdapter.BookListener,BookAdapter.BookListener {

    companion object{
        const val INTENT_BOOK_KEY="book"
    }
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    lateinit var names:ArrayList<Book>;
    lateinit var sliderView: SliderView;

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var adapter: BookAdapter
    private lateinit var adapter2: BookAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recyclerView = _binding!!.popularRecycler
        val recyclerView2 = _binding!!.foryouRecycler
        initViews(recyclerView)
        initViews2(recyclerView2)

        homeViewModel.bestsellers.observe(this.viewLifecycleOwner, Observer {
            adapter2= BookAdapter(context,it,this)
            recyclerView.adapter=adapter2
        })
           homeViewModel.featured.observe(this.viewLifecycleOwner, Observer {
            adapter= BookAdapter(context,it,this)
       recyclerView2.adapter=adapter
        })


        return root

        //slider
/*        sliderView=_binding!!.imageSlider
        sliderView.setSliderAdapter(SliderAdapter())
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM)
//sliderView.setCustomSliderTransformAnimation(SliderAnimations.CUBEOUTSCALINGTRANSFORMATION);
        sliderView.startAutoCycle()*/

    }

    private fun initViews(recycler: RecyclerView) {
        recycler.setHasFixedSize(true)


        recycler.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
//        layoutManager.spanSizeLookup=object =GridLayoutManager.SpanSizeLookup
    }

    private fun initViews2(recycler: RecyclerView) {
        recycler.setHasFixedSize(true)


        recycler.layoutManager = LinearLayoutManager(context)
//        layoutManager.spanSizeLookup=object =GridLayoutManager.SpanSizeLookup
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

        override fun onClikc(adapterPosition: Int, book: Book?) {
        startActivity(Intent(activity, BookDetailActivity::class.java).putExtra(INTENT_BOOK_KEY,book))

    }

    override fun onClikc(adapterPostion: Int) {
        TODO("Not yet implemented")
    }


}