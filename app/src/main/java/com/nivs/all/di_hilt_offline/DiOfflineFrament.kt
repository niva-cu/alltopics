package com.nivs.all.di_hilt_offline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nivs.all.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiOfflineFrament : Fragment() {

    private val viewModel by viewModels<ProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frament_di_offline, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val t1:TextView = view.findViewById<TextView>(R.id.name_label)
            t1.text = viewModel.getProfile().name
        t1.append("\n${viewModel.getProfile().age.toString()}")
    }
}