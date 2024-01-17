package com.compass.test.compasstest.config

import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(
    properties = [
        "spring.profiles.active=test"
    ]
)
@Tag("integration")
class SpringBootTestConfig {

    @Value("\${local.server.port}")
    val port: Int = 0

    @BeforeEach
    fun setup() {
        RestAssured.port = port
    }
}
