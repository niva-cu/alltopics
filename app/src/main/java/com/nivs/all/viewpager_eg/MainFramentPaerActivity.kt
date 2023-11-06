package com.nivs.all.navDrawer_viewPager.anoter_viewpaer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.nivs.all.R
import com.nivs.all.viewpager_eg.FragmentPagerAdapter

class MainFragmentPagerActivity: AppCompatActivity() {
    private var tabTitle = arrayOf("Home", "First", "Second")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpaer_tab)

        val viewPager: ViewPager2 = findViewById(R.id.viewPagerTab)
        viewPager.adapter = FragmentPagerAdapter(supportFragmentManager, lifecycle)

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Set tab text or icon here if needed
            //tab.text = "Tab ${position + 1}"
            tab.text = tabTitle[position]
        }.attach()

        //val fragments = listOf(FirstFragment(), SecondFragment(), HomeFragment()) // Replace with your fragment instances
        //val adapter = FramentPaerAdapter(fragments, supportFragmentManager)
    }
}