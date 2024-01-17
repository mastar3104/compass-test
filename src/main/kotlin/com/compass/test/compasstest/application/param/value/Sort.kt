package com.compass.test.compasstest.application.param.value

enum class Sort {
    Name,
    LoginId;

    companion object {
        fun of(value: String): Sort {
            return values().find { it.name.lowercase() == value.lowercase() } ?: throw IllegalArgumentException("$value に対応する値はありません。")
        }
    }
}
