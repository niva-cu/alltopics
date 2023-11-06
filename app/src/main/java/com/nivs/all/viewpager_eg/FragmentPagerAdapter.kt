package com.nivs.all.viewpager_eg

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nivs.all.FirstFragment
import com.nivs.all.HomeFragment
import com.nivs.all.SecondFragment

class FragmentPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return HomeFragment()
            1 -> return FirstFragment()
            2 -> return SecondFragment()
            else -> return HomeFragment()
        }
    }
}