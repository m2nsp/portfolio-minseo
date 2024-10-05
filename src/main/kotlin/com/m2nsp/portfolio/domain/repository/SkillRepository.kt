package com.m2nsp.portfolio.domain.repository

import com.m2nsp.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long>