package com.compass.test.compasstest.infrastructure.query.resource

data class StudentResource(
    val id: Int,
    val name: String,
    val loginId: String,
    val classroomId: Int,
    val classroomName: String,
    val facilitatorId: Int,
)
