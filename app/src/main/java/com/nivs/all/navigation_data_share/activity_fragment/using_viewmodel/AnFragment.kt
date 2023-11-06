package com.nivs.all.navigation_data_share.activity_fragment.using_viewmodel

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import com.nivs.all.R
import com.nivs.all.SecondFragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AnFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val framentViewModel : FramentViewModel by activityViewModels()
    private lateinit var textHi : TextView
    private lateinit var edtText : EditText
    private lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_an, container, false)
        textHi = view.findViewById(R.id.textview_an)
        framentViewModel.data.observe(viewLifecycleOwner) {
            textHi.text = it.toString()
        }



        edtText = view.findViewById(R.id.editText_an)
        btn = view.findViewById(R.id.button_an)
        btn.setOnClickListener(){
            val bundle = Bundle()
            bundle.putString("Hi", edtText.text.toString())
            val fragment = AnotherFragment()
            fragment.arguments = bundle
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout1, fragment).commit()
            }
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AnFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}