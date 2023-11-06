package com.nivs.all.navigation_data_share.fragment_fragment_navgraph

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Exam(
    val courseName: String,
    val midtermExamScore: Double,
    val finalExamScore: Double,
) : Parcelable