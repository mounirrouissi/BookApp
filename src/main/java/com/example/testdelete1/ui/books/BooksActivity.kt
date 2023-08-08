package com.example.testdelete1.ui.books

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.SearchView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnewbest.recycler.BookAdapter
import com.example.testdelete1.R
import com.example.testdelete1.models.Book
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.bottomnewbest.retrofit.ApiService
import com.example.bottomnewbest.retrofit.Repository
import com.example.testdelete1.databinding.ActivityBooksBinding
import com.example.testdelete1.models.JsonBook

class BooksActivity : AppCompatActivity(), BookAdapter.BookListener {
    private lateinit var binding: ActivityBooksBinding
    private lateinit var viewModel:BookViewModel
    var popular_recycler: RecyclerView? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_new, R.id.navigation_best
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        binding.buttonSecond.setOnClickListener {
//        findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)


//        homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)


        popular_recycler = findViewById(R.id.recyclerView) as RecyclerView
        popular_recycler?.setHasFixedSize(true)
        popular_recycler?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search,menu)
        val searchView=menu?.findItem(R.id.search_item)?.actionView as SearchView
        val searchManager=getSystemService(Context.SEARCH_SERVICE)as SearchManager
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        return true
    }

//    handling the intent

    private fun performSearch(term:String){
        val service = ApiService.instance
        val repository = Repository(service)


        repository.searchAllBooks(term).enqueue(object : Callback<List<JsonBook>> {
            override fun onResponse(
                call: Call<List<JsonBook>>,
                response: Response<List<JsonBook>>
            )
            {
                Log.i("Search Response === ", response.body()!!.toString())

                val adapter=BookAdapter(this@BooksActivity,response.body(),this@BooksActivity)
                popular_recycler!!.adapter=adapter

//                        text.setText(response.body()!!.name)

            }

            override fun onFailure(call: Call<List<JsonBook>>, t: Throwable) {
                Log.i("Search Error ===", t.message.toString())
            }
        })
    }
    private fun handleIntent(intent: Intent){
        if(Intent.ACTION_SEARCH == intent.action){
            val query =intent.getStringExtra(SearchManager.QUERY)
            Log.i("query ==== ", query.toString())

            return performSearch(query!!)  //not in the book
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleIntent(intent!!)
    }

    //***    handling the intent


    override fun onClikc(adapterPosition: Int, book: Book?) {
        startActivity(Intent(this,BookDetailActivity::class.java))

    }
}