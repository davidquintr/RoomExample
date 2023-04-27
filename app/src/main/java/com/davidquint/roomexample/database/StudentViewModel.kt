package com.davidquint.roomexample.database

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class StudentViewModel(private val repository: StudentRepository) : ViewModel() {
    val allStudents : LiveData<List<Student>> = repository.allStudents.asLiveData()

    fun insertStudent(student: Student) = viewModelScope.launch{
        repository.insertStudent(student)
    }
}

class StudentViewModelFactory(private val repository: StudentRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StudentViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return StudentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknow viewModel class")
    }
}