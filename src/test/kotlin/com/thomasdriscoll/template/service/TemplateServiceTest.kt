package com.thomasdriscoll.template.service

import com.nhaarman.mockitokotlin2.mock
import com.thomasdriscoll.template.lib.dao.TemplateRepo
import com.thomasdriscoll.template.lib.exceptions.DriscollException
import com.thomasdriscoll.template.lib.exceptions.ExceptionResponses
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

internal class TemplateServiceTest {

    //Complete dummy variable but just wanted to highlight that
    // you'd probably have one of these in your service tests
    private lateinit var templateRepo: TemplateRepo
    private lateinit var templateService: TemplateService
    @BeforeEach
    fun setup(){
        templateRepo = mock()
        templateService = TemplateService(templateRepo)
    }

    @Nested
    @DisplayName("Dummy function service tests")
    inner class DummyFunctionServiceTests(){
        private val name : String = "Thomas"
        private val badName : String = "Thummus"
        private val nameResponse : String = "My name is Thomas"

        @Test
        fun whenValidName_returnNameWithMessage() {
            val actual : String = templateService.dummyFunction(name)
            assertEquals(nameResponse, actual)
        }

        @Test
        fun whenInvalidName_throwException() {
            val excepted : DriscollException = DriscollException(ExceptionResponses.TESTING_EXCEPTIONS.status,
                                                                 ExceptionResponses.TESTING_EXCEPTIONS.message)

            val actual : DriscollException = Assertions.assertThrows(DriscollException::class.java) {templateService.dummyFunction(badName)}
            assertEquals(excepted.status,actual.status)
            assertEquals(excepted.message,actual.message)
        }
    }
}