package com.compass.test.compasstest.domain.entity

import com.compass.test.compasstest.domain.value.ClassroomId
import com.compass.test.compasstest.domain.value.FacilitatorId

class Classroom private constructor(
    val id: ClassroomId,
    val name: String,
    val facilitatorId: FacilitatorId,
) {
    companion object {
        // QueryService等外部の値からクラスへマッピングする
        fun reconstructor(
            id: ClassroomId,
            name: String,
            facilitatorId: FacilitatorId,
        ): Classroom {
            return Classroom(
                id,
                name,
                facilitatorId,
            )
        }
    }
}
