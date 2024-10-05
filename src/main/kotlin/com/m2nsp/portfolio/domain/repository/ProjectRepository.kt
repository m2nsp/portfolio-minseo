package com.m2nsp.portfolio.domain.repository

import com.m2nsp.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long>