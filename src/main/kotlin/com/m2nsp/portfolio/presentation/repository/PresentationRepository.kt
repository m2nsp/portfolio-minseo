package com.m2nsp.portfolio.presentation.repository

import com.m2nsp.portfolio.domain.entity.*
import com.m2nsp.portfolio.domain.repository.*
import org.springframework.stereotype.Repository

//facade repository
@Repository
class PresentationRepository(
    private val achievementRepository: AchievementRepository,
    private val experienceRepository: ExperienceRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val projectRepository: ProjectRepository,
    private val skillRepository: SkillRepository
){
    fun getActiveAchievements(): List<Achievement>{
        return achievementRepository.findAllByIsActive(isActive = true)     //캡슐화하기 위함
    }
    fun getActiveExperiences(): List<Experience>{
        return experienceRepository.findAllByIsActive(isActive = true)
    }
    fun getActiveIntroductions(): List<Introduction>{
        return introductionRepository.findAllByIsActive(isActive = true)
    }
    fun getActiveLinks(): List<Link>{
        return linkRepository.findAllByIsActive(isActive = true)
    }
    fun getActiveProjects(): List<Project>{
        return projectRepository.findAllByIsActive(isActive = true)
    }
    fun getActiveSkills(): List<Skill>{
        return skillRepository.findAllByIsActive(isActive = true)
    }
}