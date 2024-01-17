package com.compass.test.compasstest.infrastructure.adapter

import com.compass.test.compasstest.infrastructure.query.resource.StudentResource
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface StudentsMapper {

    @Select(
        "<script>",
        " select",
        "    student.id, ",
        "    student.name, ",
        "    student.login_id, ",
        "    classroom.id as classroom_id, ",
        "    classroom.name as classroom_name, ",
        "    facilitator.id as facilitator_id ",
        " from student ",
        " join classroom ",
        " on student.classroom_id = classroom.id ",
        " join facilitator ",
        " on classroom.facilitator_id = facilitator.id ",
        " where facilitator.id = #{facilitatorId} ",
        " and student.deleted = false ",
        " and classroom.deleted = false ",
        " and facilitator.deleted = false ",
        "<if test=\"nameLike != ''\">",
        " and student.name LIKE CONCAT('%', #{nameLike}, '%') ",
        "</if>",
        "<if test=\"loginIdLike != ''\">",
        " and student.login_id LIKE CONCAT('%', #{loginIdLike}, '%') ",
        "</if>",
        " order by ",
        " <choose>",
        "   <when test=\"sort == 'Name'\">",
        "       student.name",
        "   </when>",
        "   <otherwise>",
        "       student.login_id",
        "   </otherwise>",
        " </choose>",
        " <choose>",
        "   <when test=\"order == 'Desc'\">",
        "       DESC",
        "   </when>",
        "   <otherwise>",
        "       ASC",
        "   </otherwise>",
        " </choose>",
        " limit #{limit} offset #{page} ",
        "</script>"
    )
    fun get(facilitatorId: Int, page: Int, limit: Int, sort: String, order: String, nameLike: String, loginIdLike: String): List<StudentResource>
}
