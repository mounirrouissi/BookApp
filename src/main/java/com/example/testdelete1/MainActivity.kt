package com.example.testdelete1

import android.content.ActivityNotFoundException
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.testdelete1.databinding.ActivityMainBinding
import com.example.testdelete1.models.BooksBanner
import com.example.testdelete1.models.Constants
import com.example.testdelete1.ui.slider.MainTopSliderAdapter
import com.opensooq.pluto.PlutoView
import com.opensooq.pluto.base.PlutoAdapter
import com.opensooq.pluto.listeners.OnItemClickListener
import com.opensooq.pluto.listeners.OnSlideChangeListener
import android.widget.Toast

import android.content.Intent
import android.view.MenuItem
import com.example.testdelete1.ui.settings.SettingsActivity


class   MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            val i = Intent(Intent.ACTION_SEND)
            i.type = "message/rfc822"
            i.putExtra(Intent.EXTRA_EMAIL, arrayOf("mounirrouissi2@gmail.com"))
            i.putExtra(Intent.EXTRA_SUBJECT, "subject of email")
            i.putExtra(Intent.EXTRA_TEXT, "body of email")
            try {
                startActivity(Intent.createChooser(i, "Send mail..."))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(
                    this,
                    "There are no email clients installed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
     /*       Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()*/
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        // home top slider
        val pluto = findViewById<PlutoView>(R.id.slider_view)
        val adapter = MainTopSliderAdapter(Constants.getAvenger(), object :
            OnItemClickListener<BooksBanner> {
            override fun onItemClicked(item: BooksBanner?, position: Int) {
                Log.d(TAG, "on Item clicked $position ${item?.imdbRating}")
            }
        })

        pluto.create(adapter, lifecycle = lifecycle)
        pluto.setOnSlideChangeListener(object : OnSlideChangeListener {
            override fun onSlideChange(adapter: PlutoAdapter<*, *>, position: Int) {
                Log.d(TAG, "on slide change $position ")

            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {

           R.id.action_settings->startActivity(Intent(this,SettingsActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}