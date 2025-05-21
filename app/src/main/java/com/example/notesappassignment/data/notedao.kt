package com.example.notesappassignment.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notesappassignment.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface notedao {
    @Query("Select * FROM notes order by id DESC")
    fun getallnotes(): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertnote(note:Note)

    @Delete
    suspend fun deletenote(note:Note)
}