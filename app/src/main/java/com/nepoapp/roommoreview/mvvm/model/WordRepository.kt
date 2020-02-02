package com.nepoapp.roommoreview.mvvm.model

import com.nepoapp.roommoreview.data.WordDao
import com.nepoapp.roommoreview.domain.Word

class WordRepository (private val dao: WordDao){

    var wordsASC = dao.fetchASC()

    suspend fun insert(word: Word){
        dao.insert(word)
    }



}