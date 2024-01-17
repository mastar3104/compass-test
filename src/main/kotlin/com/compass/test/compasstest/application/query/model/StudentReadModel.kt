package com.compass.test.compasstest.application.query.model

import com.compass.test.compasstest.domain.entity.Classroom
import com.compass.test.compasstest.domain.entity.Student

data class StudentReadModel(
    val student: Student,
    val classroom: Classroom,
)
