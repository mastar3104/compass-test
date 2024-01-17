package com.compass.test.compasstest.application.usecase

import com.compass.test.compasstest.application.param.value.Limit
import com.compass.test.compasstest.application.param.value.LoginIdLike
import com.compass.test.compasstest.application.param.value.NameLike
import com.compass.test.compasstest.application.param.value.Order
import com.compass.test.compasstest.application.param.value.Page
import com.compass.test.compasstest.application.param.value.Sort
import com.compass.test.compasstest.application.query.StudentsQueryService
import com.compass.test.compasstest.application.query.model.StudentReadModel
import com.compass.test.compasstest.domain.value.FacilitatorId
import org.springframework.stereotype.Component

@Component
class GetStudentsUseCase(
    private val studentsQueryService: StudentsQueryService,
) {
    suspend fun exec(
        facilitatorId: FacilitatorId,
        page: Page,
        limit: Limit,
        sort: Sort,
        order: Order,
        nameLike: NameLike,
        loginIdLike: LoginIdLike,
    ): List<StudentReadModel> {
        return studentsQueryService.get(
            facilitatorId,
            page,
            limit,
            sort,
            order,
            nameLike,
            loginIdLike,
        )
    }
}
