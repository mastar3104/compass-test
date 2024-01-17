package com.compass.test.compasstest.application.view

data class StudentsView(
    val students: List<Student>,
) {
    val totalCount = students.size

    data class Student(
        val id: Int,
        val name: String,
        val loginId: String,
        val classroom: Classroom,
    )

    data class Classroom(
        val id: Int,
        val name: String,
    )
}
