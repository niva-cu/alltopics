package com.nivs.all.navigation_LeftRightBottom

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.nivs.all.FirstFragment
import com.nivs.all.HomeFragment
import com.nivs.all.R
import com.nivs.all.SecondFragment
import com.nivs.all.databinding.ActivityNavigationBotomBinding
//https://c1ctech.com/android-bottomnavigationview-example-in-kotlin/
class BottomNavigationActivity: AppCompatActivity() {
    private lateinit var binding: ActivityNavigationBotomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBotomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = getSupportActionBar()

        loadFragment(HomeFragment())

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            var fragment: Fragment
            when (item.itemId) {
                R.id.nav_home -> {
                    toolbar?.setTitle("Home")
                    fragment = HomeFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.nav_gallery -> {
                    toolbar?.setTitle("Radio")
                    fragment = FirstFragment()
                    loadFragment(fragment)
                    true

                }
                R.id.nav_slideshow -> {
                    toolbar?.setTitle("Search")
                    fragment = SecondFragment()
                    loadFragment(fragment)
                    true

                }

                else -> false
            }

        }

        binding.bottomNavigation.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Home Item reselected", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_slideshow -> {
                    Toast.makeText(this, "Slide reselected", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_gallery -> {
                    Toast.makeText(this, "Gallery reselected", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}