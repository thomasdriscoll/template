package com.thomasdriscoll.template.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController;
import com.thomasdriscoll.template.service.TemplateService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable

@RestController
class TemplateController(
        private val templateService : TemplateService
) {
    @GetMapping("/{name}")
    fun sanityCheck(
            @PathVariable name: String
    ) : ResponseEntity<String>{
        return ResponseEntity.ok().body(templateService.dummyFunction(name))
    }

}