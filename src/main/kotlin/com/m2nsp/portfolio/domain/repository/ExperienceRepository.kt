package com.m2nsp.portfolio.domain.repository

import com.m2nsp.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ExperienceRepository : JpaRepository<Experience, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Experience>

    override fun findById(id: Long): Optional<Experience>
    //JpaRepository에 정의되어있기 때문에 오버라이딩 해줘야됨
}