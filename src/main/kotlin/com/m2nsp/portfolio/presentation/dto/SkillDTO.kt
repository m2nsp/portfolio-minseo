package com.m2nsp.portfolio.presentation.dto

import com.m2nsp.portfolio.domain.entity.Skill
data class SkillDTO(
    val name: String,
    val type: String
) {
    constructor(skill: Skill) : this(
        name = skill.name,
        type = skill.type.name
    )
}