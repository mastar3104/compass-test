package com.compass.test.compasstest

import com.compass.test.compasstest.config.SpringBootTestConfig
import io.restassured.RestAssured
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test

class GetStudentsTest_正常系 : SpringBootTestConfig() {

    @Test
    fun `facilitator_id=1に紐づく生徒情報を取得できること(その他の絞り込み条件、ソート条件の指定なし)`() {
        RestAssured.given()
            .param("facilitator_id", "1")
            .`when`()
            .get("/students")
            .then()
            .statusCode(200)
            .body("students.size()", Matchers.equalTo(3))
            .body("totalCount", Matchers.equalTo(3))
            .body("students[0].id", Matchers.equalTo(1))
            .body("students[0].name", Matchers.equalTo("あいだ"))
            .body("students[0].loginId", Matchers.equalTo("alice"))
            .body("students[0].classroom.id", Matchers.equalTo(1))
            .body("students[0].classroom.name", Matchers.equalTo("特待クラス1"))
            .body("students[1].id", Matchers.equalTo(2))
            .body("students[2].id", Matchers.equalTo(3))
    }

    @Test
    fun `facilitation_id=3, ソート条件=loginId, ソート順=昇順 の情報を取得できること`() {
        RestAssured.given()
            .param("facilitator_id", "3")
            .param("sort", "loginId")
            .param("order", "asc")
            .`when`()
            .get("/students")
            .then()
            .statusCode(200)
            .body("students.size()", Matchers.equalTo(5))
            .body("totalCount", Matchers.equalTo(5))
            .body("students[0].id", Matchers.equalTo(10))
            .body("students[0].name", Matchers.equalTo("こさか"))
            .body("students[0].loginId", Matchers.equalTo("felix"))
            .body("students[0].classroom.id", Matchers.equalTo(4))
            .body("students[0].classroom.name", Matchers.equalTo("普通科クラス2"))
            .body("students[1].loginId", Matchers.equalTo("gai"))
            .body("students[2].loginId", Matchers.equalTo("hilary"))
            .body("students[3].loginId", Matchers.equalTo("ivy"))
            .body("students[4].loginId", Matchers.equalTo("jack"))
    }

    @Test
    fun `facilitation_id=3, ソート条件=loginId, ソート順=降順 の情報を取得できること`() {
        RestAssured.given()
            .param("facilitator_id", "3")
            .param("sort", "loginId")
            .param("order", "desc")
            .`when`()
            .get("/students")
            .then()
            .statusCode(200)
            .body("students.size()", Matchers.equalTo(5))
            .body("totalCount", Matchers.equalTo(5))
            .body("students[0].id", Matchers.equalTo(6))
            .body("students[0].name", Matchers.equalTo("かまくら"))
            .body("students[0].loginId", Matchers.equalTo("jack"))
            .body("students[0].classroom.id", Matchers.equalTo(3))
            .body("students[0].classroom.name", Matchers.equalTo("普通科クラス1"))
            .body("students[1].loginId", Matchers.equalTo("ivy"))
            .body("students[2].loginId", Matchers.equalTo("hilary"))
            .body("students[3].loginId", Matchers.equalTo("gai"))
            .body("students[4].loginId", Matchers.equalTo("felix"))
    }

    @Test
    fun `facilitation_id=3, ソート条件=name, ソート順=昇順 の情報を取得できること`() {
        RestAssured.given()
            .param("facilitator_id", "3")
            .param("sort", "name")
            .param("order", "asc")
            .`when`()
            .get("/students")
            .then()
            .statusCode(200)
            .body("students.size()", Matchers.equalTo(5))
            .body("totalCount", Matchers.equalTo(5))
            .body("students[0].id", Matchers.equalTo(6))
            .body("students[0].name", Matchers.equalTo("かまくら"))
            .body("students[0].loginId", Matchers.equalTo("jack"))
            .body("students[0].classroom.id", Matchers.equalTo(3))
            .body("students[0].classroom.name", Matchers.equalTo("普通科クラス1"))
            .body("students[1].name", Matchers.equalTo("きじま"))
            .body("students[2].name", Matchers.equalTo("くらもと"))
            .body("students[3].name", Matchers.equalTo("けんとく"))
            .body("students[4].name", Matchers.equalTo("こさか"))
    }

    @Test
    fun `facilitation_id=3, ソート条件=name, ソート順=降順 の情報を取得できること`() {
        RestAssured.given()
            .param("facilitator_id", "3")
            .param("sort", "name")
            .param("order", "desc")
            .`when`()
            .get("/students")
            .then()
            .statusCode(200)
            .body("students.size()", Matchers.equalTo(5))
            .body("totalCount", Matchers.equalTo(5))
            .body("students[0].id", Matchers.equalTo(10))
            .body("students[0].name", Matchers.equalTo("こさか"))
            .body("students[0].loginId", Matchers.equalTo("felix"))
            .body("students[0].classroom.id", Matchers.equalTo(4))
            .body("students[0].classroom.name", Matchers.equalTo("普通科クラス2"))
            .body("students[1].name", Matchers.equalTo("けんとく"))
            .body("students[2].name", Matchers.equalTo("くらもと"))
            .body("students[3].name", Matchers.equalTo("きじま"))
            .body("students[4].name", Matchers.equalTo("かまくら"))
    }

    @Test
    fun `facilitation_id=3, limit=3 の場合、先頭3件のみの情報を取得できること`() {
        RestAssured.given()
            .param("facilitator_id", "3")
            .param("limit", "3")
            .`when`()
            .get("/students")
            .then()
            .statusCode(200)
            .body("students.size()", Matchers.equalTo(3))
            .body("totalCount", Matchers.equalTo(3))
            .body("students[0].id", Matchers.equalTo(10))
            .body("students[0].name", Matchers.equalTo("こさか"))
            .body("students[0].loginId", Matchers.equalTo("felix"))
            .body("students[0].classroom.id", Matchers.equalTo(4))
            .body("students[0].classroom.name", Matchers.equalTo("普通科クラス2"))
            .body("students[1].id", Matchers.equalTo(9))
            .body("students[2].id", Matchers.equalTo(8))
    }

    @Test
    fun `facilitation_id=3, limit=3, page=1 の場合、2~4件のみの情報を取得できること`() {
        RestAssured.given()
            .param("facilitator_id", "3")
            .param("limit", "3")
            .param("page", "1")
            .`when`()
            .get("/students")
            .then()
            .statusCode(200)
            .body("students.size()", Matchers.equalTo(3))
            .body("totalCount", Matchers.equalTo(3))
            .body("students[0].id", Matchers.equalTo(9))
            .body("students[0].name", Matchers.equalTo("けんとく"))
            .body("students[0].loginId", Matchers.equalTo("gai"))
            .body("students[0].classroom.id", Matchers.equalTo(4))
            .body("students[0].classroom.name", Matchers.equalTo("普通科クラス2"))
            .body("students[1].id", Matchers.equalTo(8))
            .body("students[2].id", Matchers.equalTo(7))
    }

    @Test
    fun `facilitation_id=3, name_like=(空文字), loginId_like=i 絞り込み条件の情報を取得できること`() {
        RestAssured.given()
            .param("facilitator_id", "3")
            .param("sort", "name")
            .param("order", "asc")
            .param("name_like", "")
            .param("loginId_like", "i")
            .`when`()
            .get("/students")
            .then()
            .statusCode(200)
            .body("students.size()", Matchers.equalTo(4))
            .body("totalCount", Matchers.equalTo(4))
            .body("students[0].id", Matchers.equalTo(7))
            .body("students[0].name", Matchers.equalTo("きじま"))
            .body("students[0].loginId", Matchers.equalTo("ivy"))
            .body("students[0].classroom.id", Matchers.equalTo(3))
            .body("students[0].classroom.name", Matchers.equalTo("普通科クラス1"))
            .body("students[1].loginId", Matchers.equalTo("hilary"))
            .body("students[2].loginId", Matchers.equalTo("gai"))
            .body("students[3].loginId", Matchers.equalTo("felix"))
    }

    @Test
    fun `facilitation_id=3, name_like=く, loginId_like=i 絞り込み条件の情報を取得できること`() {
        RestAssured.given()
            .param("facilitator_id", "3")
            .param("sort", "name")
            .param("order", "asc")
            .param("name_like", "く")
            .param("loginId_like", "i")
            .`when`()
            .get("/students")
            .then()
            .statusCode(200)
            .body("students.size()", Matchers.equalTo(2))
            .body("totalCount", Matchers.equalTo(2))
            .body("students[0].id", Matchers.equalTo(8))
            .body("students[0].name", Matchers.equalTo("くらもと"))
            .body("students[0].loginId", Matchers.equalTo("hilary"))
            .body("students[0].classroom.id", Matchers.equalTo(4))
            .body("students[0].classroom.name", Matchers.equalTo("普通科クラス2"))
            .body("students[1].name", Matchers.equalTo("けんとく"))
            .body("students[1].loginId", Matchers.equalTo("gai"))
    }

    @Test
    fun `facilitator_id=4に紐づく生徒情報は存在しないため、空配列が取得できること`() {
        RestAssured.given()
            .param("facilitator_id", "4")
            .`when`()
            .get("/students")
            .then()
            .statusCode(200)
            .body("students.size()", Matchers.equalTo(0))
            .body("totalCount", Matchers.equalTo(0))
    }
}
