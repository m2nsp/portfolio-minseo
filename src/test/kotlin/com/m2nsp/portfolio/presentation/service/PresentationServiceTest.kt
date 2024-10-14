package com.m2nsp.portfolio.presentation.service

import com.m2nsp.portfolio.domain.entity.Introduction
import com.m2nsp.portfolio.domain.entity.Link
import com.m2nsp.portfolio.presentation.repository.PresentationRepository
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.expect

@ExtendWith(MockitoExtension::class)
class PresentationServiceTest{

    @InjectMocks        //실제로 테스트를 할 대상
    lateinit var presentationService: PresentationService

    @Mock
    lateinit var presentationRepository: PresentationRepository

    val DATA_SIZE = 9

    @Test
    fun testGetIntroduction(){
        //given
        val introductions = mutableListOf<Introduction>()
        for (i in 1..DATA_SIZE){
            val introduction = Introduction(content = "${i}", isActive = i%2==0)
            introductions.add(introduction)
        }

        val activeIntroductions = introductions.filter{ introduction ->
            introduction.isActive        //it.isActive랑 똑같음
        }
        Mockito.`when`(presentationRepository.getActiveIntroductions())
            .thenReturn(activeIntroductions)

        //when
        val introductionDTOs = presentationService.getIntroductions()

        //then
        Assertions.assertThat(introductionDTOs).hasSize(DATA_SIZE / 2)
        for (introductionDTO in introductionDTOs){
            assertThat(introductionDTO.content.toInt()).isEven()
        }
    }

    @Test
    fun testGetLinks(){
        //given
        val links = mutableListOf<Link>()
        for(i in 1..DATA_SIZE){
            val link = Link(name = "${i}", content = "${i}", isActive = i%2 != 0)
            links.add(link)
        }

        val activeLinks = links.filter { link ->
            link.isActive
        }

        Mockito.`when`(presentationRepository.getActiveLinks())
            .thenReturn(activeLinks)

        //when
        val linkDTOs = presentationService.getLinks()

        //then
        var expectedSize = DATA_SIZE/2
        if(DATA_SIZE % 2 != 0){
            expectedSize += 1
        }
        assertThat(linkDTOs).hasSize(expectedSize)
        for (linkDTO in linkDTOs){
            assertThat(linkDTO.content.toInt()).isOdd()
        }
    }
}