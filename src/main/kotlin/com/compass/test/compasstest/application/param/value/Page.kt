package com.compass.test.compasstest.application.param.value

data class Page(
    val value: Int
) {
    init {
        require(value >= 0) {
            "pageは0以上の自然数を指定してください。"
        }
    }
}
