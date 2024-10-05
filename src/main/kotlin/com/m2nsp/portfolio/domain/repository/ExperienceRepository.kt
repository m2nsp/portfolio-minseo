package com.m2nsp.portfolio.domain.repository

import com.m2nsp.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository : JpaRepository<Experience, Long>