package com.nivs.all.di_hilt_offline

// A resource
data class Profile(
    val name: String,
    val age: Int
)

// A simple interface which returns the resource.
// This will help us mock the data source when executing tests.
interface DataRepository {
    fun getProfile(): Profile
}