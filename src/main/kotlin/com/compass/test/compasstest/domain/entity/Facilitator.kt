package com.compass.test.compasstest.domain.entity

import com.compass.test.compasstest.domain.value.FacilitatorId

class Facilitator private constructor(
    val id: FacilitatorId,
    val name: String,
) {
    companion object {
        // QueryService等外部の値からクラスへマッピングする
        fun reconstructor(
            id: FacilitatorId,
            name: String,
        ): Facilitator {
            return Facilitator(
                id,
                name,
            )
        }
    }
}
