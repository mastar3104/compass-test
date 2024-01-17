package com.compass.test.compasstest.domain.value

data class FacilitatorId(
    private val value: Int,
) {
    fun toInt(): Int {
        return value
    }
}
