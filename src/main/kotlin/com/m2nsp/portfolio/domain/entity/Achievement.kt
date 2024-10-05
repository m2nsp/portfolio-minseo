package com.m2nsp.portfolio.domain.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Achievement(
    //생성자 정의
    title: String,
    description: String,
    achievedDate: LocalDate?,
    host: String,
    isActive: Boolean
) : BaseEntity() {
    //ID 생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")
    var id: Long? = null

    //필드 생성
    var title: String = title

    var description: String = description

    var achievedDate: LocalDate? = achievedDate

    var host: String = host

    var isActive: Boolean = isActive

}