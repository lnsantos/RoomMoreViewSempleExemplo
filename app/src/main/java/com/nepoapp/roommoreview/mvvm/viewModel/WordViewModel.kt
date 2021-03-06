package com.nepoapp.roommoreview.mvvm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nepoapp.roommoreview.data.db.WordRoomDatabase
import com.nepoapp.roommoreview.domain.Word
import com.nepoapp.roommoreview.mvvm.model.WordRepository
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application){

    private val dbInstance : WordRoomDatabase?
    private var wordRepository : WordRepository

    private var _words : LiveData<List<Word>>? = null

    init {
        dbInstance = WordRoomDatabase.getDatabase(application.applicationContext,viewModelScope)!!
        wordRepository = WordRepository(dbInstance.wordDao())
        _words = wordRepository.wordsASC
    }

    fun insertWord(word:Word) = viewModelScope.launch {
        wordRepository.insert(word)
    }

    fun getWords(): LiveData<List<Word>>? {
        return _words
    }

}
