package com.nivs.all.db_room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainDBViewModel @Inject constructor(wordRepository: WordRepository) : ViewModel() {
    private var wordRepository = wordRepository
    fun saveWord(text: String) = liveData(){
        try{
            wordRepository.insertWord(Word(0,text))
            emit(true)
        } catch (e : Exception){
                emit(false)
            }
        }

    fun getAllWord() = wordRepository.getAllWord()

}