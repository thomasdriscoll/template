package com.thomasdriscoll.template.lib.exceptions

import org.springframework.http.HttpStatus

enum class ExceptionResponses(val status: HttpStatus, val message: String){
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "You done goofed")
}