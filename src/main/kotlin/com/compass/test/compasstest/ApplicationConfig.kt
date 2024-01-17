package com.compass.test.compasstest

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
@MapperScan("com.compass.test.compasstest.infrastructure.adapter")
class ApplicationConfig {

    @Bean
    fun sqlSessionFactory(dataSource: DataSource?, applicationContext: ApplicationContext): SqlSessionFactory? {
        val factoryBean = SqlSessionFactoryBean()
        factoryBean.setDataSource(dataSource)
        return factoryBean.getObject()
    }
}
