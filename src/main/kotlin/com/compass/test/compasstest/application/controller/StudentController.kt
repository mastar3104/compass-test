package com.compass.test.compasstest.application.controller

import com.compass.test.compasstest.application.param.value.Limit
import com.compass.test.compasstest.application.param.value.LoginIdLike
import com.compass.test.compasstest.application.param.value.NameLike
import com.compass.test.compasstest.application.param.value.Order
import com.compass.test.compasstest.application.param.value.Page
import com.compass.test.compasstest.application.param.value.Sort
import com.compass.test.compasstest.application.usecase.GetStudentsUseCase
import com.compass.test.compasstest.application.view.StudentsViewFactory
import com.compass.test.compasstest.domain.value.FacilitatorId
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Pattern
import kotlinx.coroutines.coroutineScope
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController(
    private val getStudentsUseCase: GetStudentsUseCase
) {

    @GetMapping("/students")
    suspend fun get(
        @RequestParam("facilitator_id") facilitatorId: Int,
        @Min(0)
        @RequestParam page: Int = 0,
        @Min(1)
        @RequestParam limit: Int = 10,
        @Pattern(regexp = "name|loginId")
        @RequestParam sort: String = "loginId",
        @Pattern(regexp = "asc|desc")
        @RequestParam order: String = "asc",
        @RequestParam("name_like") nameLike: String = "",
        @RequestParam("loginId_like") loginIdLike: String = "",
    ) = coroutineScope {

        val studentList = getStudentsUseCase.exec(
            facilitatorId = FacilitatorId(facilitatorId),
            page = Page(page),
            limit = Limit(limit),
            sort = Sort.of(sort),
            order = Order.of(order),
            nameLike = NameLike(nameLike),
            loginIdLike = LoginIdLike(loginIdLike),
        )

        StudentsViewFactory.create(
            studentList
        )
    }
}
