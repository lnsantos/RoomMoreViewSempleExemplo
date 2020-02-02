package com.nepoapp.roommoreview.mvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nepoapp.roommoreview.R
import com.nepoapp.roommoreview.domain.Word
import kotlinx.android.synthetic.main.recyclerview_items.view.*

class WordRecyclerViewAdapter(ctx:Context) :
    RecyclerView.Adapter<WordRecyclerViewAdapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(ctx)
    private var words = emptyList<Word>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder
        = WordViewHolder(inflater.inflate(R.layout.recyclerview_items,parent,false))

    override fun getItemCount(): Int = words.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.wordItemView.text = words[position].word
    }

    internal fun setWords(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.textView
    }
}