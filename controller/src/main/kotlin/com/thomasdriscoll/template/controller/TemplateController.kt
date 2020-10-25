package com.thomasdriscoll.template.controller

import com.thomasdriscoll.template.lib.responses.DriscollResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController;
import com.thomasdriscoll.template.service.TemplateService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable

@RestController
class TemplateController(
        private val templateService : TemplateService
) {
    @GetMapping("/{name}")
    fun sanityCheck(
            @PathVariable name: String
    ) : ResponseEntity<DriscollResponse<String>>{
        return ResponseEntity.ok().body(DriscollResponse(HttpStatus.OK.value(), templateService.dummyFunction(name)))
    }

}