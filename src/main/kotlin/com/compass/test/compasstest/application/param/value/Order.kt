package com.compass.test.compasstest.application.param.value

enum class Order {
    Asc,
    Desc;

    companion object {
        fun of(value: String): Order {
            return values().find { it.name.lowercase() == value.lowercase() } ?: throw IllegalArgumentException("$value に対応する値はありません。")
        }
    }
}
