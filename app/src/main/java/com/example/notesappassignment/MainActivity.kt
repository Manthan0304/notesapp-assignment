package com.example.notesappassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.notesappassignment.data.notedatabase
import com.example.notesappassignment.ui.NoteApp
import com.example.notesappassignment.ui.theme.NotesappAssignmentTheme
import com.example.notesappassignment.viewmodel.noteviewmodel
import com.example.notesappassignment.viewmodel.viewmodelfactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = notedatabase.getDatabase(this)
        val dao = db.notedao()
        val factory = viewmodelfactory(dao)
        val viewModel = ViewModelProvider(this,factory)[noteviewmodel::class.java]

        enableEdgeToEdge()
        setContent {
            NoteApp(viewModel)
        }
    }
}

