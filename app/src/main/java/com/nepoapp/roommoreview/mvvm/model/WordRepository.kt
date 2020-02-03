package com.nepoapp.roommoreview.mvvm.model

import androidx.lifecycle.LiveData
import com.nepoapp.roommoreview.data.WordDao
import com.nepoapp.roommoreview.domain.Word

class WordRepository (private val dao: WordDao){
    var wordsASC : LiveData<List<Word>>? = null

    init {
        wordsASC = dao.fetchASC()
    }

    suspend fun insert(word: Word){
        dao.insert(word)
    }



}