package com.nivs.all.navigation_data_share.fragment_fragment_navgraph

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.nivs.all.R
import com.nivs.all.databinding.ActivityFragfragNavdataBinding

//https://www.youtube.com/watch?v=jqwUsarn5vQ
//https://www.youtube.com/watch?v=6fdvIb5fNGg
//https://www.youtube.com/watch?v=5HDUD8H-Lgo
//https://blog.devgenius.io/passing-data-with-navigation-component-in-android-7fa0ef9119b4
//https://github.com/emineinan/NavigationSafeArgs/tree/master/app
//https://medium.com/@mr.appbuilder/navigating-android-fragments-with-the-navigation-component-part-1-1d238e000313
//https://medium.com/@mr.appbuilder/passing-data-to-a-destination-fragment-in-android-using-safe-args-part-2-d7cb1f21587
class FragFragDataNavGraphActivity:AppCompatActivity() {

    private lateinit var binding: ActivityFragfragNavdataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragfragNavdataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_bottem_navigation)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //  navController.navigate(R.id.navigation_homfragemnt)

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.home_fragment,
            R.id.addNoteFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

    }
    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
    }
}