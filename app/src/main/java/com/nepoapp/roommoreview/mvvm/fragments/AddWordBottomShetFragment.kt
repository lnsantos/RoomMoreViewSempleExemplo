package com.nepoapp.roommoreview.mvvm.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nepoapp.roommoreview.R
import com.nepoapp.roommoreview.domain.Word
import com.nepoapp.roommoreview.mvvm.viewModel.WordViewModel
import kotlinx.android.synthetic.main.dialog_fragment_new_word.*

class AddWordBottomShetFragment : BottomSheetDialogFragment(){

    private lateinit var viewModel : WordViewModel

    companion object{
        fun newInstance() : AddWordBottomShetFragment
            = AddWordBottomShetFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.dialog_fragment_new_word,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(WordViewModel::class.java)
        button_save.setOnClickListener(listenerSaveNewWord())

    }

    private fun listenerSaveNewWord() = View.OnClickListener {

            viewModel.insertWord(Word(edit_word.text.trim().toString()))
            dismiss()
    }
}
