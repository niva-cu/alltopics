package com.nivs.all.navigation_data_share.fragment_fragment_navgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nivs.all.R
import com.nivs.all.databinding.FragmentExamBinding
import com.nivs.all.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {
        private lateinit var binding: FragmentScoreBinding

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = FragmentScoreBinding.inflate(inflater, container, false)
            return binding.root
        }
    }
