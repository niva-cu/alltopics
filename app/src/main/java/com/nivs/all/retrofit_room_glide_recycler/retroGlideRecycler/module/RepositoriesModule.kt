package com.nivs.all.retrofit_room_glide_recycler.retroGlideRecycler.module

import com.nivs.all.retrofit_room_glide_recycler.retroGlideRecycler.data.MainRepository
import com.nivs.all.retrofit_room_glide_recycler.retroGlideRecycler.data.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoriesModule {

    @Binds
    fun mainRepository(mainRepositoryImpl: MainRepositoryImpl) : MainRepository
}