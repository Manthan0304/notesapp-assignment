package com.example.notesappassignment.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description : String
)

//val samplenotes = listOf(
//    Note("Meeting1","Discuss about the internship at practicebuzz"),
//    Note("Meeting2","Discuss about the job at practicebuzz")
//)