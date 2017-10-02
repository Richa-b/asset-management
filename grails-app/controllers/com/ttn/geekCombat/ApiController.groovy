package com.ttn.geekCombat

import com.ttn.geekCombat.dto.APIResponseDTO
import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

class ApiController {
    SpringSecurityService springSecurityService

    def index() {
        APIResponseDTO apiResponseDTO = APIResponseDTO.getSuccessDto("Test Successful Message");
        apiResponseDTO.data = "Welcome " + springSecurityService.currentUser?.username
        render apiResponseDTO as JSON
    }
}
