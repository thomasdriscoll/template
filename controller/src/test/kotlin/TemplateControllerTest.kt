package com.thomasdriscoll.template.controller

import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import com.thomasdriscoll.template.service.TemplateService
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.MockMvc

internal class TemplateControllerTest {
    private lateinit var templateService: TemplateService
    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setup(){
        templateService = mock()
    }

    @Nested
    inner class SanityCheckTests{
        @Test
        fun `Test if it works`(){

        }

        @Test
        fun `Test what happens when it breaks`(){

        }
    }
}