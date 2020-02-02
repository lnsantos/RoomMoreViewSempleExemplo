package com.nepoapp.roommoreview

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word")
data class Word (
    @PrimaryKey @ColumnInfo(name = "word") val word: String?
)