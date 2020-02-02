package com.nepoapp.roommoreview.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nepoapp.roommoreview.domain.Word

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun fetchASC(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAllData()
}