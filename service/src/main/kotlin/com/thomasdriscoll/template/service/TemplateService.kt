package com.thomasdriscoll.template.service

import com.thomasdriscoll.template.lib.exceptions.ExceptionResponses
import com.thomasdriscoll.template.lib.exceptions.TemplateException
import org.springframework.stereotype.Service

@Service
class TemplateService {

    fun dummyFunction(name: String) : String{
        if(name == "Brian"){
            throw TemplateException(ExceptionResponses.BAD_REQUEST.message)
        }
        return name
    }
}