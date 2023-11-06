package com.nivs.all

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.MutableLiveData
import com.nivs.all.databinding.ActivityMainBinding
import com.nivs.all.lifecycle.ObserverLife

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("MAIN","onCreate: MAIN");
        lifecycle.addObserver(ObserverLife())
        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val mld : MutableLiveData<Boolean> = MutableLiveData()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onPostResume() {
        super.onPostResume()
        Log.d("MAIN","onPostResume: MAIN")
    }
    override fun onStart() {
        super.onStart()
        Log.d("MAIN","onStart: MAIN")
    }
    override fun onResume() {
        super.onResume()
        Log.d("MAIN","onResume: MAIN")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MAIN","onPause: MAIN")
    }
    override fun onStop() {
        super.onStop()
        Log.d("MAIN","onStop: MAIN")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MAIN","onDestroy: MAIN")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MAIN","onRestart: MAIN")
    }
}