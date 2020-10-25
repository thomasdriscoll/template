package com.thomasdriscoll.template

import org.springframework.stereotype.Service

@Service
class TemplateService {

    fun dummyFunction() : String{
        return ""
    }

    fun swearToMe(name: String) : String{
        return name;
    }
}