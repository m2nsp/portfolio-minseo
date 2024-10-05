package com.m2nsp.portfolio.domain.repository

import com.m2nsp.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long>