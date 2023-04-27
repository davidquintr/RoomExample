package com.davidquint.roomexample.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_student")
class Student(@PrimaryKey @ColumnInfo(name = "name") val name : String,@ColumnInfo(name = "age") val age : Int,@ColumnInfo(name = "cats") val cats : Int)