package com.compass.test.compasstest.application.param.value

data class Limit(
    val value: Int
) {
    init {
        require(value > 0) {
            "limitは1以上の整数で指定してください。"
        }
    }
}
