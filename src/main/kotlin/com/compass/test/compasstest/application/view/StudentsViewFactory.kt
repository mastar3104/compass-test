package com.compass.test.compasstest.application.view

import com.compass.test.compasstest.application.query.model.StudentReadModel

object StudentsViewFactory {
    fun create(students: List<StudentReadModel>): StudentsView {
        return StudentsView(
            students = students.map {
                StudentsView.Student(
                    id = it.student.id.toInt(),
                    name = it.student.name,
                    loginId = it.student.loginId,
                    classroom = StudentsView.Classroom(
                        id = it.classroom.id.toInt(),
                        name = it.classroom.name,
                    )
                )
            }
        )
    }
}
