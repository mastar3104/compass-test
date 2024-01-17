package com.compass.test.compasstest.domain.value

data class StudentId(
    private val value: Int
) {
    fun toInt(): Int {
        return value
    }
}
