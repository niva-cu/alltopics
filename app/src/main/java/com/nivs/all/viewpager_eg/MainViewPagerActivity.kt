package com.nivs.all.viewpager_eg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nivs.all.databinding.ActivityViewpagerBinding

class MainViewPagerActivity: AppCompatActivity() {
    private lateinit var binding: ActivityViewpagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewpagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager2()
    }

    private fun setupViewPager2() {
        val list: MutableList<String> = ArrayList()
        list.add("This is your First Screen")
        list.add("This is your Second Screen")
        list.add("This is your Third Screen")
        list.add("This is your Fourth Screen")

        val colorList: MutableList<String> = ArrayList()
        colorList.add("#00ff00")
        colorList.add("#ff0000")
        colorList.add("#0000ff")
        colorList.add("#f0f0f0")

        // Set adapter to viewPager.
        binding.viewPager.adapter = ViewPagerAdapter(this, list, colorList)
    }
}