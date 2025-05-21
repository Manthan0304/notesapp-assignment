package com.example.notesappassignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notesappassignment.data.notedao

class viewmodelfactory (private val dao : notedao) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass:Class<T>):T{
        return noteviewmodel(dao) as T
    }
}