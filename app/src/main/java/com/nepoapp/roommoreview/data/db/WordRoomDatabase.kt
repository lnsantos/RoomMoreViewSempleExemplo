package com.nepoapp.roommoreview.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nepoapp.roommoreview.data.WordDao
import com.nepoapp.roommoreview.domain.Word

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase(){

    abstract fun wordDao() : WordDao

    companion object{
        private var INSTANCE_DABASE : WordRoomDatabase? = null
        fun getDatabase(ctx:Context) : WordRoomDatabase?{
            INSTANCE_DABASE?.apply {
                 return INSTANCE_DABASE
            }
            synchronized(this){
                INSTANCE_DABASE = Room.databaseBuilder(
                    ctx.applicationContext,
                    WordRoomDatabase::class.java,
                    "wordsempledatabase")
                    .build()
            }
            return INSTANCE_DABASE
        }
    }

}