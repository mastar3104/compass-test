package com.compass.test.compasstest.domain.entity

import com.compass.test.compasstest.domain.value.ClassroomId
import com.compass.test.compasstest.domain.value.StudentId

class Student private constructor(
    val id: StudentId,
    val loginId: String,
    val name: String,
    val classroomId: ClassroomId,
) {
    companion object {
        // QueryService等外部の値からクラスへマッピングする
        fun reconstructor(
            id: StudentId,
            loginId: String,
            name: String,
            classroomId: ClassroomId,
        ): Student {
            return Student(
                id,
                loginId,
                name,
                classroomId,
            )
        }
    }
}
