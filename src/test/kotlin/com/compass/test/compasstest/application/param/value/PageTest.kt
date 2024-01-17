package com.compass.test.compasstest.application.param.value

import org.junit.jupiter.api.assertThrows
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

class PageTest : Spek({

    describe("constructor: バリデーションを実施して、リクエストパラメータのVOを生成") {
        it("自然数である場合、VOを生成できること") {
            val actual = Page(1)
            assertEquals(1, actual.value)
        }

        it("-1未満の値である場合、例外が発生すること") {
            val error = assertThrows<IllegalArgumentException> {
                Page(-1)
            }
            assertEquals("pageは0以上の自然数を指定してください。", error.message)
        }
    }
})
