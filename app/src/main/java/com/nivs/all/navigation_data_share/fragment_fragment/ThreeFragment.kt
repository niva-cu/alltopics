package com.nivs.all.navigation_data_share.fragment_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.nivs.all.databinding.FragmentThreeBinding

class ThreeFragment : Fragment() {
    private var _binding: FragmentThreeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_second, container, false)
        _binding = FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonPrevious.setOnClickListener {
            //pass result to the FirstFragment through FragmentManager
            setFragmentResult("key_previous", bundleOf("say_hi_previous" to "Hi first fragment"))
            parentFragmentManager.popBackStack()
        }
    }
}