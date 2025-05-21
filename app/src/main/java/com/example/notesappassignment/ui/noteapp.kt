package com.example.notesappassignment.ui

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.notesappassignment.AddNoteDialog
import com.example.notesappassignment.NoteList
import com.example.notesappassignment.data.samplenotes
import com.example.notesappassignment.model.Note


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteApp() {
    var notes by remember { mutableStateOf(samplenotes.toMutableStateList()) }
    var showdialog by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showdialog = true }) {
                Icon(Icons.Default.Add, contentDescription = "Add Note")
            }
        },
        topBar = {
            TopAppBar(title = { Text("Notes App") })
        }
    ) { paddingValues ->
        NoteList(
            notes = notes,
            onNoteclick = {note->
                Toast.makeText(context , note.description, Toast.LENGTH_SHORT).show() },
            modifier = Modifier.padding(paddingValues)
        )

        if(showdialog){
            AddNoteDialog(
                onAdd = {title,description ->
                    if(title.isNotBlank() && description.isNotBlank()){
                        notes.add(Note(title,description))
                        showdialog = false
                }
                },
                onDismiss = {showdialog = false}
            )
        }
    }
}












