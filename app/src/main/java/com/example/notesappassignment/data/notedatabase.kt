package com.example.notesappassignment.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesappassignment.model.Note


@Database(entities = [Note::class],version = 1)
abstract class notedatabase : RoomDatabase(){
    abstract fun notedao(): notedao

    companion object{
        @Volatile private var Instance: notedatabase? = null

        fun getDatabase(context: Context):notedatabase{
            return Instance?:synchronized(this) {
                Room.databaseBuilder(context,notedatabase::class.java,"note_database").build().also{Instance = it}
            }
        }

    }
}