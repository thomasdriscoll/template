package com.thomasdriscoll.template.lib.exceptions

import org.springframework.http.HttpStatus

class TemplateException(message: String) : Exception(message)

enum class ExceptionResponses(val code: Int, val message: String){
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), "You done goofed")
}