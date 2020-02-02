package com.nepoapp.roommoreview.domain

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word (
    @PrimaryKey @Nullable @ColumnInfo(name = "word") val word: String

)