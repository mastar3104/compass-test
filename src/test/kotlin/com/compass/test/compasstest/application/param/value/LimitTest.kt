package com.compass.test.compasstest.application.param.value

import org.junit.jupiter.api.assertThrows
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

class LimitTest : Spek({

    describe("constructor: バリデーションを実施して、リクエストパラメータのVOを生成") {
        it("自然数である場合、VOを生成できること") {
            val actual = Limit(1)
            assertEquals(1, actual.value)
        }

        it("0未満の値である場合、例外が発生すること") {
            val error = assertThrows<IllegalArgumentException> {
                Limit(0)
            }
            assertEquals("limitは1以上の整数で指定してください。", error.message)
        }
    }
})
