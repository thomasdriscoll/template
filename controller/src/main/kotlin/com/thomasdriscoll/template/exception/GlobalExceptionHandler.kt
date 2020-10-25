package com.thomasdriscoll.template.exception

import com.thomasdriscoll.template.lib.exceptions.DriscollException
import com.thomasdriscoll.template.lib.responses.DriscollResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(DriscollException::class)
    fun templateExceptions(e: DriscollException): ResponseEntity<DriscollResponse<String>> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(DriscollResponse(e.code, e.message))
    }

}