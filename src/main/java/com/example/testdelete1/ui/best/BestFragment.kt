package com.example.bottomnewbest.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnewbest.recycler.BookAdapter
import com.example.testdelete1.databinding.FragmentBestBinding

class BestFragment : Fragment() {

    private lateinit var bestViewModel: BestViewModel
    private var _binding: FragmentBestBinding? = null
    var popular_recycler: RecyclerView? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bestViewModel =
            ViewModelProvider(this).get(BestViewModel::class.java)

        _binding = FragmentBestBinding.inflate(inflater, container, false)
        val root: View = binding.root


        popular_recycler = _binding!!.bestRecyclerView
        popular_recycler?.setHasFixedSize(true)
        popular_recycler?.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

        bestViewModel.data.observe(this.viewLifecycleOwner, {
            Log.d("TAG ====",it.toString())
            val adapter= BookAdapter(context,it,null)
            popular_recycler!!.adapter=adapter
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}