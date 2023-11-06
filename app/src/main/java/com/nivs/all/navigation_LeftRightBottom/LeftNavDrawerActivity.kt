package com.nivs.all.navigation_LeftRightBottom

import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.nivs.all.R
import com.nivs.all.databinding.ActivityMainNavdrawerBinding

class LeftNavDrawerActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainNavdrawerBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainNavdrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // setSupportActionBar(binding.toolbar)

        navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.home_dest),
            binding.drawerLayout
        )

        setupActionBar(navController, appBarConfiguration)
        setupNavigationMenu(navController)

        setupClickListener()
    }

    private fun closeDrawer() {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }

    private fun setupActionBar(navController: NavController, appBarConfig: AppBarConfiguration) {
        setupActionBarWithNavController(navController, appBarConfig)
    }

    private fun setupNavigationMenu(navController: NavController) {
        binding.navDrawer.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }

    private fun setupClickListener() {
        // Set item click listener to perform action on menu item click.
        binding.navDrawer.setNavigationItemSelectedListener { menuItem -> // Toggle the checked state of menuItem.
            menuItem.isChecked = !menuItem.isChecked
            when (menuItem.itemId) {
                R.id.nav_gallery -> {
                    navController.navigate(R.id.action_home_to_gallery)
                }
                R.id.nav_slideshow -> {
                    navController.navigate(R.id.action_home_to_slideshow)
                }
            }
            Toast.makeText(
                applicationContext,
                menuItem.title.toString() + " Selected",
                Toast.LENGTH_SHORT
            ).show()
            closeDrawer()
            true
        }
    }
}
