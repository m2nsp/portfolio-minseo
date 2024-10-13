package com.m2nsp.portfolio.domain.repository

import com.m2nsp.portfolio.domain.entity.Experience
import com.m2nsp.portfolio.domain.entity.ExperienceDetail
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.time.Year

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExperienceRepositoryTest(
    @Autowired val experienceRepository: ExperienceRepository
) {    //이 경우 dataInitializer이 빈으로 등록이 안됨 -> 별도로 데이터 초기화 메소드 작성
    val DATA_SIZE = 10

    //테스트 데이터 초기화시 더미 엔티티 만들어주는 역할
    private fun createExperience(n: Int): Experience{       //받은 n의 개수만큼 experience 안에 detail 넣어줄꺼임
        val experience = Experience(
            title = "${n}",
            description = "테스트 설명 ${n}",
            startYear = 2023,
            startMonth = 9,
            endYear = 2023,
            endMonth = 9,
            isActive = true
        )

        val details = mutableListOf<ExperienceDetail>()
        for(i in 1..n){
            val experienceDetail = ExperienceDetail(content = "테스트${i}", isActive = true)
            details.add(experienceDetail)       //만든 디테일을 details 리스트에 넣음
        }
        experience.addDetails(details)          //만든 details를 experience에 추가

        return experience
    }

    @BeforeAll  //데이터 실제로 초기화
    fun beforeAll(){
        println("----- 데이터 초기화 이전 조회 시작 -----")
        val beforeInitialize = experienceRepository.findAll()
        assertThat(beforeInitialize).hasSize(0)      //테스트 검증 - 데이터의 사이즈 체크 :: 0이면 테스트 통과
        println("----- 데이터 초기화 이전 조회 종료 -----")

        println("----- 테스트 데이터 초기화 시작 -----")
        val experiences = mutableListOf<Experience>()
        for (i in 1..DATA_SIZE){
            val experience = createExperience(i)
            experiences.add(experience)

        }
        experienceRepository.saveAll(experiences)
        println("----- 테스트 데이터 초기화 종료 -----")
    }

    @Test
    fun testFindAll(){
        println("----- findAll 테스트 시작 -----")
        val experiences = experienceRepository.findAll()
        assertThat(experiences).hasSize(DATA_SIZE)
        println("experiences.size: ${experiences.size}")

        for(experience in experiences){
            assertThat(experience.details).hasSize(experience.title.toInt())
            println("experience.details.size: ${experience.details.size}")
        }
        println("----- findAll 테스트 종료 -----")
    }

    @Test
    fun testFindAllByIsActive(){
        println("----- findAllByIsActive 테스트 시작 -----")
        val experiences = experienceRepository.findAllByIsActive(isActive = true)
        assertThat(experiences).hasSize(DATA_SIZE)
        println("experiences.size: ${experiences.size}")

        for(experience in experiences){
            assertThat(experience.details).hasSize(experience.title.toInt())
            println("experience.details.size: ${experience.details.size}")
        }
        println("----- findAllByIsActive 테스트 종료 -----")
    }
}