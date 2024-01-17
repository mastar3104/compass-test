package com.compass.test.compasstest.infrastructure.query.resource

import com.compass.test.compasstest.application.query.model.StudentReadModel
import com.compass.test.compasstest.domain.entity.Classroom
import com.compass.test.compasstest.domain.entity.Student
import com.compass.test.compasstest.domain.value.ClassroomId
import com.compass.test.compasstest.domain.value.FacilitatorId
import com.compass.test.compasstest.domain.value.StudentId

object StudentReadModelFactory {

    fun create(resources: List<StudentResource>): List<StudentReadModel> {
        return resources.map {
            StudentReadModel(
                student = Student.reconstructor(
                    id = StudentId(it.id),
                    loginId = it.loginId,
                    name = it.name,
                    classroomId = ClassroomId(it.classroomId),
                ),
                classroom = Classroom.reconstructor(
                    id = ClassroomId(it.classroomId),
                    name = it.classroomName,
                    facilitatorId = FacilitatorId(it.facilitatorId),
                )
            )
        }
    }
}
