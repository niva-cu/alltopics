package com.nivs.all.di_hilt_offline

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repo: DataRepository
) : ViewModel() {

    fun getProfile(): Profile = repo.getProfile()
}