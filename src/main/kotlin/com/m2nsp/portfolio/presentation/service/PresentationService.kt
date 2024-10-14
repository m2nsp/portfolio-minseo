package com.m2nsp.portfolio.presentation.service

import com.m2nsp.portfolio.presentation.dto.IntroductionDTO
import com.m2nsp.portfolio.presentation.dto.LinkDTO
import com.m2nsp.portfolio.presentation.dto.ProjectDTO
import com.m2nsp.portfolio.presentation.dto.ResumeDTO
import com.m2nsp.portfolio.presentation.repository.PresentationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PresentationService(
    private val presentationRepository: PresentationRepository
){
    //메인 페이지 호출 컨트롤러에서 호출
    @Transactional(readOnly = true)     //readOnly의 경우 수정이 없으므로 스냅샷 생략
    fun getIntroductions():List<IntroductionDTO>{       //Introduction 조회하는 function
        val introductions = presentationRepository.getActiveIntroductions()

        return introductions.map { IntroductionDTO(it) }        //introductions 각각을 introductionDTO에 넣어서 리스트를 만들어서 리턴해주는 것임
    }

    @Transactional(readOnly = true)
    fun getLinks(): List<LinkDTO>{
        val links = presentationRepository.getActiveLinks()

        return links.map{ LinkDTO(it) }
    }

    //레쥬메 페이지에서 호출
    @Transactional(readOnly = true)
    fun getResume() : ResumeDTO{
        val experiences = presentationRepository.getActiveExperiences()
        val achievements = presentationRepository.getActiveAchievements()
        val skills = presentationRepository.getActiveSkills()

        return ResumeDTO(
            experiences = experiences,
            achievements = achievements,
            skills = skills,
        )
    }

    //프로젝트 페이지에서 호출
    @Transactional(readOnly = true)
    fun getProjects(): List<ProjectDTO>{
        val projects = presentationRepository.getActiveProjects()

        return projects.map {ProjectDTO(it) }
    }
}