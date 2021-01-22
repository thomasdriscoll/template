package com.thomasdriscoll.template.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.nhaarman.mockitokotlin2.*
import com.thomasdriscoll.template.lib.exceptions.DriscollException
import com.thomasdriscoll.template.lib.exceptions.ExceptionResponses
import com.thomasdriscoll.template.lib.responses.DriscollResponse
import com.thomasdriscoll.template.service.TemplateService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
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
        mockMvc = standaloneSetup(templateController).build()
    }

    @Nested
    @DisplayName("Dummy Function Controller Tests")
    inner class DummyFunctionControllerTests{
        private val name :String = "Brian"
        private val badName :String = "Thummus"
        private val nameResponse = "My name is Brian"

        @Test
        fun givenName_whenGetName_thenReturnResponseEntity(){
            // Declare expected response and other variables used only in this test
            // Note: ObjectMapper here is mapping Java objects to JSON objects for you
            val expected:String  = ObjectMapper().writeValueAsString(DriscollResponse(HttpStatus.OK.value(),nameResponse))

            //Mock what needs to be mocked
            whenever(templateService.dummyFunction(name)).thenReturn(nameResponse)

            val result: MvcResult = mockMvc.perform(get("/$name")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andReturn()

            //Assert if test worked
            val actual:String = result.response.contentAsString
            assertEquals(expected,actual)
        }
        @Test
        fun givenInvalidName_whenGetName_thenReturnException(){
            //variables local to test
            val exception = DriscollException(ExceptionResponses.TESTING_EXCEPTIONS.status,
                                                                 ExceptionResponses.TESTING_EXCEPTIONS.message)
            val expected: String = ObjectMapper().writeValueAsString(DriscollResponse(exception.status.value(), exception.message))

            //Mock what needs to be mocked
            whenever(templateService.dummyFunction(badName)).thenThrow(exception) // <- BAD BAD LINE
            //Do test
            val result: MvcResult = mockMvc.perform(get("/$badName")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest)
                .andReturn()

            //Assert if test worked
            val actual: String = result.response.contentAsString
            assertEquals(expected, actual)
        }
    }

//    private lateinit var templateService: TemplateService
//    private lateinit var templateController: TemplateController
//    private lateinit var mockMvc: MockMvc
//
//
//    @BeforeEach
//    fun setup(){
//        templateService = mock()
//        templateController = TemplateController(templateService)
//        mockMvc = standaloneSetup(templateController)
//                    .build()
//
//    }
//
//    private val NAME = "thomas"
//    private val BNAME = "Brian"
//    private val RESPONSE = "thomas"
//    private val ERR = DriscollException(ExceptionResponses.TESTING_EXCEPTIONS.status,ExceptionResponses.TESTING_EXCEPTIONS.message)

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