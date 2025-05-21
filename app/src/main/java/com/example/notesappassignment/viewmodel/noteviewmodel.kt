package com.example.notesappassignment.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesappassignment.data.notedao
import com.example.notesappassignment.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class noteviewmodel(private val dao:notedao) : ViewModel() {
    val notes:StateFlow<List<Note>> = dao.getallnotes()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())


    var showdialog by mutableStateOf(false)
        private set
    fun addNote(title:String,description:String){
        viewModelScope.launch {
            dao.insertnote(Note(title = title, description = description))
        }
        showdialog = false
    }

    fun deleteNote(note:Note){
        viewModelScope.launch {
            dao.deletenote(note)
        }
    }

    fun dismissDialog(){
        showdialog = false
    }

    fun opendialog(){
        showdialog = true
    }
}