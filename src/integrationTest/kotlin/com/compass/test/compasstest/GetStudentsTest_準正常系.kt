package com.compass.test.compasstest

import com.compass.test.compasstest.config.SpringBootTestConfig
import io.restassured.RestAssured
import org.junit.jupiter.api.Test

class GetStudentsTest_準正常系 : SpringBootTestConfig() {

    @Test
    fun `facilitator_idに文字列を指定した場合、400が返されること`() {
        RestAssured.given()
            .param("facilitator_id", "test")
            .`when`()
            .get("/students")
            .then()
            .statusCode(400)
    }

    @Test
    fun `facilitator_idをリクエストしなかった場合、400が返されること`() {
        RestAssured.given()
            .param("sort", "name")
            .param("order", "asc")
            .param("name_like", "く")
            .param("loginId_like", "i").`when`()
            .get("/students")
            .then()
            .statusCode(400)
    }

    @Test
    fun `pageに文字列を指定した場合、400が返されること`() {
        RestAssured.given()
            .param("facilitator_id", "1")
            .param("page", "test")
            .`when`()
            .get("/students")
            .then()
            .statusCode(400)
    }

    @Test
    fun `pageに-1を指定した場合、400が返されること`() {
        RestAssured.given()
            .param("facilitator_id", "1")
            .param("page", "-1")
            .`when`()
            .get("/students")
            .then()
            .statusCode(400)
    }

    @Test
    fun `limitに文字列を指定した場合、400が返されること`() {
        RestAssured.given()
            .param("facilitator_id", "1")
            .param("limit", "test")
            .`when`()
            .get("/students")
            .then()
            .statusCode(400)
    }

    @Test
    fun `limitに0を指定した場合、400が返されること`() {
        RestAssured.given()
            .param("facilitator_id", "1")
            .param("limit", "0")
            .`when`()
            .get("/students")
            .then()
            .statusCode(400)
    }

    @Test
    fun `sortに規定値以外の文字列を指定した場合、400が返されること`() {
        RestAssured.given()
            .param("facilitator_id", "1")
            .param("sort", "test")
            .`when`()
            .get("/students")
            .then()
            .statusCode(400)
    }

    @Test
    fun `orderに規定値以外の文字列を指定した場合、400が返されること`() {
        RestAssured.given()
            .param("facilitator_id", "1")
            .param("order", "test")
            .`when`()
            .get("/students")
            .then()
            .statusCode(400)
    }
}
