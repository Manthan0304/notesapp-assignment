package com.example.notesappassignment.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notesappassignment.model.Note

@Composable
fun NoteList(
    notes: List<Note>,
    onNoteclick: (Note) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(notes) { note ->
            NoteCard(note = note, onClick = { onNoteclick(note) })
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}