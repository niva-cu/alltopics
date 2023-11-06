package com.nivs.all.di_hilt_offline

import javax.inject.Inject

// Simple implementation of data source
class DataRepoImpl @Inject constructor() : DataRepository {
    override fun getProfile(): Profile =
        Profile(name = "ABC", age = 2023)

}
