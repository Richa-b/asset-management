package com.ttn.geekCombat

import com.ttn.geekCombat.dto.APIResponseDTO
import com.ttn.geekCombat.dto.UserDTO
import grails.converters.JSON
import grails.rest.RestfulController

class UtilController extends RestfulController {

    UtilController() {
        super(Test)
    }

    def test(UserDTO userDTO) {

        bindData(userDTO,request.getJSON())
        APIResponseDTO apiResponseDTO = APIResponseDTO.getSuccessDto("Test Successful Message");
        apiResponseDTO.data = userDTO
        render apiResponseDTO as JSON
    }
}
