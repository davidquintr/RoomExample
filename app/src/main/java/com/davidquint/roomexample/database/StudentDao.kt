package com.davidquint.roomexample.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {

    @Query("SELECT * from tbl_student order by name ASC")
    fun getAlphabetStudents(): Flow<List<Student>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStudent(student: Student)

    @Query("DELETE FROM tbl_student")
    suspend fun deleteAllStudents()

}