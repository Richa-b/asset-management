package com.ttn.geekCombat.dto

class APIResponseDTO {
    Integer statusCode = 200
    Boolean status
    String message
    Integer code
    def data

    static APIResponseDTO getErrorDto(String message) {
        new APIResponseDTO(status: false, message: message, statusCode: 500)
    }
    static APIResponseDTO getSuccessDto(String message) {
        new APIResponseDTO(status: true, statusCode: 200, message: message)
    }

    static APIResponseDTO getNoContentDto(String message) {
        new APIResponseDTO(status: true, statusCode: 200, message: message)
    }

    void setInternalServerErrorResponse(Exception e, Integer code = 500) {
        message = e.getMessage()
        statusCode = code
        status = false
    }

    void    populateApiErrorResponseDTO(Exception e, String msg = null, Integer code = 500) {
        message = msg ?: e.getMessage()
        statusCode = code
        status = false
    }

    void populateApiResponseDTO(String message , Boolean status, def data) {
        this.message = message
        this.status = status
        this.data = data
    }
    void populateResponseDto(String message, Integer code = 0, Boolean status = false) {
        this.status = status
        this.message = message
        this.code = code
    }

    void setErrorResponse(Exception e=null) {
        message = e.getMessage() ?:"Some error occurred while saving menu"
        status = false
        code=500
    }

    static APIResponseDTO getErrorResponseDTO(Exception e) {
        new APIResponseDTO(status: false, message: e.getMessage())
    }

    void setErrorResponse(String message) {
        this.message = message
        status = false
    }


    void populateDummyResponse(String message) {
        this.status = true
        this.message = message
    }
}
