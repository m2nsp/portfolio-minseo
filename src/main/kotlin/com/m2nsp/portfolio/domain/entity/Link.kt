package com.m2nsp.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Link(
    name: String,
    content: String,
    isActive: Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_id")
    var id: Long? = null

    var name: String = name

    var content: String = content

    //이런 것들은 column(name) 설정을 안해줬지만 CamelCase이므로 알아서 is_active 이런 식으로 매핑이 될 것임
    var isActive: Boolean = isActive

}