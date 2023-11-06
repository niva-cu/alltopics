package com.nivs.all.navigation_data_share.fragment_fragment_navgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.nivs.all.R
import com.nivs.all.databinding.FragmentExamBinding

class ExamFragment : Fragment() {
    private lateinit var binding: FragmentExamBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExamBinding.inflate(inflater, container, false)


        binding.buttonCalculateAverageScore.setOnClickListener {
            if(binding.textInputEditTextMidtermExamScore.text?.isNotEmpty() == true &&
                binding.textInputEditTextFinalExamScore.text?.isNotEmpty() == true) {
                val courseName = binding.textInputEditTextCourseName.text.toString()
                val midtermExamScore =
                    binding.textInputEditTextMidtermExamScore.text.toString().toDouble()
                val finalExamScore =
                    binding.textInputEditTextFinalExamScore.text.toString().toDouble()

                val exam = Exam(courseName, midtermExamScore, finalExamScore)

                //val action =  Directio.actionExamInformationFragmentToExamScoreFragment(exam)
                //findNavController().navigate(action)
                binding.buttonCalculateAverageScore.setOnClickListener() {
                    findNavController().navigate(R.id.action_mobile_navigation_to_addNoteFragment)
                }
                //val action = Exam
            } else {
                Toast.makeText(context,"Enter data",Toast.LENGTH_LONG).show()
            }
        }


        return binding.root
    }
}
