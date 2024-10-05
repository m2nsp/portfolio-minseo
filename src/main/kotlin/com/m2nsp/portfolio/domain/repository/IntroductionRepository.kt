package com.m2nsp.portfolio.domain.repository

import com.m2nsp.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository : JpaRepository<Introduction, Long>