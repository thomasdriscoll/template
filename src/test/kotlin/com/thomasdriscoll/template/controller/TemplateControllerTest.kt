package com.thomasdriscoll.template.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.nhaarman.mockitokotlin2.*
import com.thomasdriscoll.template.exception.GlobalExceptionHandler
import com.thomasdriscoll.template.lib.exceptions.DriscollException
import com.thomasdriscoll.template.lib.exceptions.ExceptionResponses
import com.thomasdriscoll.template.lib.responses.DriscollResponse
import com.thomasdriscoll.template.service.TemplateService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
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
        mockMvc = standaloneSetup(templateController)
                    .setControllerAdvice(GlobalExceptionHandler())
                    .build()
    }

    @Nested
    @DisplayName("Dummy Function Controller Tests")
    inner class DummyFunctionControllerTests{
        private val name : String = "Brian"
        private val badName : String = "Thummus"
        private val nameResponse : String = "My name is Brian"

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
            whenever(templateService.dummyFunction(badName)).thenThrow(exception)
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
}