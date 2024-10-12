package com.m2nsp.portfolio.domain.repository

import com.m2nsp.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long> {

    // select * from achievement where is_active = :isActive
    fun findAllByIsActive(isActive: Boolean): List<Achievement>      //이걸 실행시키면 JPA에서 알아서 쿼리를 만들어줌
    //optional 이나 Achievement 즉 entity 에는 단 건의 데이터만 저장가능 -- 여러 건의 쿼리 저장해야하면 List 로 저장!필수!

}