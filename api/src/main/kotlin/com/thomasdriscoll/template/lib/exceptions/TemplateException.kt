package com.thomasdriscoll.template.lib.exceptions

class TemplateException(message: String) : Exception(message)

enum class ExceptionResponses(val message: String){
    BAD_REQUEST("You done goofed")
}