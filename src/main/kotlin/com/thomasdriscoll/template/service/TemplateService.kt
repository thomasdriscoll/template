package com.thomasdriscoll.template.service

import com.thomasdriscoll.template.lib.dao.TemplateRepo
import com.thomasdriscoll.template.lib.exceptions.DriscollException
import com.thomasdriscoll.template.lib.exceptions.ExceptionResponses
import org.springframework.stereotype.Service

@Service
class TemplateService(val templateRepo: TemplateRepo) {

    @Throws(DriscollException::class)
    fun dummyFunction(name: String) : String {
        if(name == "Thummus"){
            throw DriscollException(ExceptionResponses.TESTING_EXCEPTIONS.status,ExceptionResponses.TESTING_EXCEPTIONS.message)
        }
        return "My name is $name"
    }
}