package com.thomasdriscoll.template.controller

import com.nhaarman.mockitokotlin2.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import com.thomasdriscoll.template.service.TemplateService
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
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
    private val RESPONSE = "thomas"

    @Nested
    inner class SanityCheckTests{
        @Test
        fun `Test if it works`(){
            whenever(templateService.dummyFunction(NAME))
                    .thenReturn(RESPONSE)

            mockMvc.perform(get("/$NAME")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk)
                    .andExpect(content().string(RESPONSE))

        }

        @Test
        fun `Test what happens when it breaks`(){

        }
    }
}