package com.thomasdriscoll.template.controller

import com.nhaarman.mockitokotlin2.*
import com.thomasdriscoll.template.lib.exceptions.DriscollException
import com.thomasdriscoll.template.lib.exceptions.ExceptionResponses
import com.thomasdriscoll.template.lib.responses.DriscollResponse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import com.thomasdriscoll.template.service.TemplateService
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

internal class TemplateControllerTest {
    private lateinit var templateService: TemplateService
    private lateinit var templateController: TemplateController
    private lateinit var mockMvc: MockMvc


    @BeforeEach
    fun setup(){
        templateService = mock()
        templateController = TemplateController(templateService)
        mockMvc = standaloneSetup(templateController)
                    .build()

    }

    private val NAME = "thomas"
    private val BNAME = "Brian"
    private val RESPONSE = "thomas"
    private val ERR = DriscollException(ExceptionResponses.TESTING_EXCEPTIONS.status,ExceptionResponses.TESTING_EXCEPTIONS.message)

//    @Nested
//    inner class SanityCheckTests{
//        @Test
//        fun `Test if it works`(){
//            whenever(templateService.dummyFunction(NAME))
//                    .thenReturn(RESPONSE)
//
//            mockMvc.perform(get("/$NAME")
//                    .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk) // this works
//                    //need to figure out how to check body
//
//
//        }
//
//        @Test
//        fun `Test what happens when it breaks`(){
//            whenever(templateService.dummyFunction(BNAME))
//                    .thenThrow(ERR)
//
//            mockMvc.perform(get("/$NAME")
//                    .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isBadRequest) // this does not work
//                    //need to figure out how to check body
//
//        }
//    }
}