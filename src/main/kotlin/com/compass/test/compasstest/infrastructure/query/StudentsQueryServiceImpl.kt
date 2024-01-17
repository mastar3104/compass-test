package com.compass.test.compasstest.infrastructure.query

import com.compass.test.compasstest.application.param.value.Limit
import com.compass.test.compasstest.application.param.value.LoginIdLike
import com.compass.test.compasstest.application.param.value.NameLike
import com.compass.test.compasstest.application.param.value.Order
import com.compass.test.compasstest.application.param.value.Page
import com.compass.test.compasstest.application.param.value.Sort
import com.compass.test.compasstest.application.query.StudentsQueryService
import com.compass.test.compasstest.application.query.model.StudentReadModel
import com.compass.test.compasstest.domain.value.FacilitatorId
import com.compass.test.compasstest.infrastructure.adapter.StudentsMapper
import com.compass.test.compasstest.infrastructure.query.resource.StudentReadModelFactory
import org.springframework.stereotype.Service

@Service
class StudentsQueryServiceImpl(
    private val mapper: StudentsMapper
) : StudentsQueryService {

    override suspend fun get(
        facilitatorId: FacilitatorId,
        page: Page,
        limit: Limit,
        sort: Sort,
        order: Order,
        nameLike: NameLike,
        loginIdLike: LoginIdLike
    ): List<StudentReadModel> {
        val resourceList = mapper.get(
            facilitatorId = facilitatorId.toInt(),
            page = page.value,
            limit = limit.value,
            sort = sort.name,
            order = order.name,
            nameLike = nameLike.value,
            loginIdLike = loginIdLike.value,
        )
        return StudentReadModelFactory.create(resourceList)
    }
}
