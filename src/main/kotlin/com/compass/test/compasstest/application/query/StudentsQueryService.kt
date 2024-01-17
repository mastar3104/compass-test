package com.compass.test.compasstest.application.query

import com.compass.test.compasstest.application.param.value.Limit
import com.compass.test.compasstest.application.param.value.LoginIdLike
import com.compass.test.compasstest.application.param.value.NameLike
import com.compass.test.compasstest.application.param.value.Order
import com.compass.test.compasstest.application.param.value.Page
import com.compass.test.compasstest.application.param.value.Sort
import com.compass.test.compasstest.application.query.model.StudentReadModel
import com.compass.test.compasstest.domain.value.FacilitatorId

interface StudentsQueryService {
    suspend fun get(
        facilitatorId: FacilitatorId,
        page: Page,
        limit: Limit,
        sort: Sort,
        order: Order,
        nameLike: NameLike,
        loginIdLike: LoginIdLike,
    ): List<StudentReadModel>
}
