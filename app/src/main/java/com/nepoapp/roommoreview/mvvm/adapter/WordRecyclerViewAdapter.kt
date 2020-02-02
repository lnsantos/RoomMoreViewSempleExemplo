package com.nepoapp.roommoreview.mvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nepoapp.roommoreview.R
import com.nepoapp.roommoreview.domain.Word

class WordRecyclerViewAdapter(ctx:Context) {

    private val inflater: LayoutInflater = LayoutInflater.from(ctx)
    private var words = emptyList<Word>() // Cached copy of words


    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.textView)
    }
}