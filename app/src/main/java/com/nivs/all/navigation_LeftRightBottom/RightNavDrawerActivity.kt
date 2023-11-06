package com.nivs.all.navigation_LeftRightBottom

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.nivs.all.R
import com.nivs.all.databinding.ActivityNavdrawerRightBinding

class RightNavDrawerActivity: AppCompatActivity() {

    private lateinit var binding: ActivityNavdrawerRightBinding

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavdrawerRightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.home_dest),
            binding.drawerLayout
        )

        setupActionBar(navController, appBarConfiguration)
        setupNavigationMenu(navController)
    }

    private fun setupActionBar(navController: NavController, appBarConfig: AppBarConfiguration) {
        setupActionBarWithNavController(navController, appBarConfig)
    }

    private fun setupNavigationMenu(navController: NavController) {
        binding.navDrawer.setupWithNavController(navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            toggle()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun toggle() {
        val direction = GravityCompat.END
        val drawerLayout = binding.drawerLayout
        if (drawerLayout.isDrawerVisible(direction)) {
            drawerLayout.closeDrawer(direction)
        } else {
            drawerLayout.openDrawer(direction)
        }
    }
}
