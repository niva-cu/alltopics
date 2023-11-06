package com.nivs.all.navigation_data_share.fragment_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.nivs.all.R
import com.nivs.all.databinding.FragmentTwoBinding
import com.nivs.all.navigation_data_share.activity_fragment.using_viewmodel.FramentViewModel

class TwoFragment : Fragment() {
    private var _binding: FragmentTwoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val button =
        //pass result to ParentFragment through FragmentManager (ParentFragmentManager)
        binding.buttonParent.setOnClickListener {
            setFragmentResult("key_parent", bundleOf("say_hi_parent" to "Hi parent fragment"))
        }

        //listen result from the ParentFragment through FragmentManager (ParentFragmentManager)
        //Once result receive show the Toast
        setFragmentResultListener("key_child") {key, result->
            // get the result from bundle
            val stringResult = result.getString("say_hi_child")
            Toast.makeText(requireContext(), "$key: $stringResult", Toast.LENGTH_SHORT).show()
        }
    }
}