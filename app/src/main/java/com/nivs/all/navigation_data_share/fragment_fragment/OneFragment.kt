package com.nivs.all.navigation_data_share.fragment_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.setFragmentResultListener
import com.nivs.all.R
import com.nivs.all.databinding.FragmentOneBinding


class OneFragment : Fragment() {
    private var _binding: FragmentOneBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_one, container, false)
        _binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //add child fragment
        childFragmentManager.beginTransaction().replace(R.id.child_fragment_container,TwoFragment()).commit()


        //listen result from the ChildFragment through childFragmentManager
        childFragmentManager.setFragmentResultListener("key_parent", this) {key, result->
            // get the result from bundle
            val stringResult = result.getString("say_hi_parent")
            Toast.makeText(requireContext(), "$key: $stringResult", Toast.LENGTH_SHORT).show()
        }

        //listen result from the SecondFragment through FragmentManager (same FragmentManager that this fragment exist)
        setFragmentResultListener("key_previous") {key, result->
            // get the result from bundle
            val stringResult = result.getString("say_hi_previous")
            Toast.makeText(requireContext(), "$key: $stringResult", Toast.LENGTH_SHORT).show()
        }

        //pass result to the ChildFragment through childFragmentManager when press the button
        binding.buttonChild.setOnClickListener {
            childFragmentManager.setFragmentResult("key_child", bundleOf("say_hi_child" to "Hi child fragment"))
        }

        //show another fragment whn click the next.
        //this will add to the same fragment manager
        binding.buttonNext.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container,TwoFragment())
                .addToBackStack(null)
                .commit()
        }

    }
}