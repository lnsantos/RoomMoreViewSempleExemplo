package com.nepoapp.roommoreview.mvvm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nepoapp.roommoreview.R
import com.nepoapp.roommoreview.domain.Word
import com.nepoapp.roommoreview.mvvm.adapter.WordRecyclerViewAdapter
import com.nepoapp.roommoreview.mvvm.fragments.AddWordBottomShetFragment
import com.nepoapp.roommoreview.mvvm.viewModel.WordViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewWord : RecyclerView
    private lateinit var adapterWord : WordRecyclerViewAdapter
    private lateinit var viewModel : WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        listener()
        observersActions()
    }

    private fun observersActions() {
        viewModel.getWords()?.observe(this,observerWords())
    }

    private fun listener() {
       fab.setOnClickListener(newWordListener())
    }

    private fun setupView() {
        recyclerViewWord = recyclerview
        adapterWord = WordRecyclerViewAdapter(this)

        recyclerViewWord.adapter = adapterWord
        recyclerViewWord.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this).get(WordViewModel::class.java)
    }

    private fun newWordListener() =  View.OnClickListener {
            var openDialog = AddWordBottomShetFragment.newInstance().apply {
                show(supportFragmentManager,AddWordBottomShetFragment::class.java.name)
            }
        }

    private fun observerWords(): Observer<in List<Word>?> = Observer {
        it?.let {
            adapterWord.setWords(it)
        }
    }


}
