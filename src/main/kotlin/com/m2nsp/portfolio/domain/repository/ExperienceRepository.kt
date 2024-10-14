package com.m2nsp.portfolio.domain.repository

import com.m2nsp.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ExperienceRepository : JpaRepository<Experience, Long> {

    @Query("select e from Experience e left join fetch e.details where e.isActive = :isActive")
    fun findAllByIsActive(isActive: Boolean): List<Experience>

    //이 경우 원래 교집합(inner join) -- 그러면 양쪽에 모두 데이터가 있어야 가져올 수 있음 --여기서는 details가 크게 의미있지 않아서 left join 사용
    @Query("select e from Experience e left join fetch e.details where e.id = :id")
    override fun findById(id: Long): Optional<Experience>
    //JpaRepository에 정의되어있기 때문에 오버라이딩 해줘야됨
}