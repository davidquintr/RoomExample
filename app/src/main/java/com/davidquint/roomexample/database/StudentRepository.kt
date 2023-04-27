package com.davidquint.roomexample.database

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class StudentRepository(private val studentDao : StudentDao) {
    val allStudents : Flow<List<Student>> = studentDao.getAlphabetStudents()

    @Suppress("RedundantSuspedModifier")
    @WorkerThread
    suspend fun insertStudent(student : Student){
        studentDao.insertStudent(student)
    }
}