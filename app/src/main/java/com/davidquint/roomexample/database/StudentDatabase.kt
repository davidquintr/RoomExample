package com.davidquint.roomexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Student::class), version = 1, exportSchema = false)
public abstract class StudentDatabase : RoomDatabase(){
    abstract fun studentDao() : StudentDao

    companion object{

        @Volatile
        private var INSTANCE : StudentDatabase? = null

        fun getDatabase(context : Context): StudentDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentDatabase::class.java,
                    "student_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }


    }

}