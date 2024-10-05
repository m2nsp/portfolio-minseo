package com.m2nsp.portfolio.domain.entity

import jakarta.persistence.*
import jakarta.servlet.http.HttpServletRequest

//http 요청 정보를 저장하기 위한 엔티티

@Entity
class HttpInterface(httpServletRequest: HttpServletRequest) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "http_interface_id")
    var id: Long? = null

    var cookies: String? = httpServletRequest.cookies
        ?.map { "${it.name}:${it.value}" }
        ?.toString()

    var referer: String? = httpServletRequest.getHeader("referer")      //http 요청 정보에서 referer 가져옴

    //referer : 요청이 어디에서부터 왔냐
    var localAddr: String? = httpServletRequest.localAddr

    var remoteAddr: String? = httpServletRequest.remoteAddr

    var remoteHost: String? = httpServletRequest.remoteHost

    var requestUri: String? = httpServletRequest.requestURI                 //서버에서 어떤 URI로 접속했는지

    var userAgent: String? = httpServletRequest.getHeader("user-Agent")     //브라우저 정보
}