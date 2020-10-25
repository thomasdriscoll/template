package com.thomasdriscoll.template.service

import com.thomasdriscoll.template.lib.exceptions.DriscollException
import com.thomasdriscoll.template.lib.exceptions.ExceptionResponses
import com.thomasdriscoll.template.lib.exceptions.TemplateException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class TemplateService {

    fun dummyFunction(name: String) : String{
        if(name == "Brian"){
            throw DriscollException(ExceptionResponses.BAD_REQUEST.code,ExceptionResponses.BAD_REQUEST.message)
        }
        return name
    }
}