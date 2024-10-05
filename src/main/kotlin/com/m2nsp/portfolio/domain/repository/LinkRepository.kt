package com.m2nsp.portfolio.domain.repository

import com.m2nsp.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long>