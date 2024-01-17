package com.compass.test.compasstest.domain.value

data class ClassroomId(
    private val value: Int
) {
    fun toInt(): Int {
        return value
    }
}
