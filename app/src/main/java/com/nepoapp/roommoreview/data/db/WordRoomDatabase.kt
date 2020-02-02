package com.nepoapp.roommoreview.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.nepoapp.roommoreview.data.WordDao
import com.nepoapp.roommoreview.domain.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.*

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase(){

    abstract fun wordDao() : WordDao

    companion object{
        private var INSTANCE_DABASE : WordRoomDatabase? = null
        fun getDatabase(ctx:Context,scope: CoroutineScope) : WordRoomDatabase?{
            INSTANCE_DABASE?.apply {
                 return INSTANCE_DABASE
            }
            synchronized(this){
                INSTANCE_DABASE = Room.databaseBuilder(
                    ctx.applicationContext,
                    WordRoomDatabase::class.java,
                    "wordsempledatabase")
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
            }
            return INSTANCE_DABASE
        }
    }

    private class WordDatabaseCallback(private val scope: CoroutineScope)
        :RoomDatabase.Callback(){

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE_DABASE?.let { dbWord ->
                scope.launch {
                    insertWhenAppIsOpen(dbWord.wordDao())
                }
            }
        }

        suspend fun insertWhenAppIsOpen(wordDao: WordDao){
            var calendar = Calendar.getInstance()
            var newWord : Word = Word(calendar.time.toString())
            wordDao.insert(newWord)
        }
    }

}
