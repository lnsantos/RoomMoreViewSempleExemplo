package com.nepoapp.roommoreview.mvvm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nepoapp.roommoreview.R
import com.nepoapp.roommoreview.mvvm.adapter.WordRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewWord : RecyclerView
    private lateinit var adapterWord : WordRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()

    }

    private fun setupView() {
        recyclerViewWord = recyclerview
        adapterWord = WordRecyclerViewAdapter(this)

        recyclerViewWord.adapter = adapterWord
        recyclerViewWord.layoutManager = LinearLayoutManager(this)
    }

}
