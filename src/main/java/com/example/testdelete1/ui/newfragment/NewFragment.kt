package com.example.testdelete1.ui.newfragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnewbest.recycler.BookAdapter
import com.example.testdelete1.databinding.FragmentNewBinding
import com.example.testdelete1.models.Book

class NewFragment : Fragment() {

    private lateinit var newViewModel: NewViewModel
    private var _binding: FragmentNewBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    //REcycler
    var subjectArrayList: ArrayList<Book> = ArrayList<Book>()

    var popular_recycler: RecyclerView? = null
//        homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        newViewModel =
            ViewModelProvider(this).get(NewViewModel::class.java)

        _binding = FragmentNewBinding.inflate(inflater, container, false)
        val root: View = binding.root

         popular_recycler = _binding!!.homeRecyclerView
        popular_recycler?.setHasFixedSize(true)
        popular_recycler?.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

        newViewModel.data.observe(viewLifecycleOwner, {
            Log.d("TAG====",it.toString())
            val adapter= BookAdapter(this.context,it,null)
            popular_recycler!!.adapter=adapter
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}