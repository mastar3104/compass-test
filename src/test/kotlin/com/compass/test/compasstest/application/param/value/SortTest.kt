package com.compass.test.compasstest.application.param.value

import org.junit.jupiter.api.assertThrows
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

class SortTest : Spek({
    describe("of: リクエストパラメータから一致するEnumを返す") {
        it("ascを渡した場合、Order.Ascが取得できること") {
            assertEquals(Sort.Name, Sort.of("name"))
        }
        it("descを渡した場合、Order.Descが取得できること") {
            assertEquals(Sort.LoginId, Sort.of("loginId"))
        }
        it("Enum紐づかない文字列を渡した場合、例外が発生すること") {
            val error = assertThrows<IllegalArgumentException> {
                Sort.of("test")
            }
            assertEquals("test に対応する値はありません。", error.message)
        }
    }
})
