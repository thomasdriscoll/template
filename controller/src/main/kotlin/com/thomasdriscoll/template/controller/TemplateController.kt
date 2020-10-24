package com.thomasdriscoll.template.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController;
import com.thomasdriscoll.template.TemplateService
import org.springframework.http.ResponseEntity

@RestController
class TemplateController(
        templateService : TemplateService
) {
    @GetMapping("/")
    fun sanityCheck() : ResponseEntity<String>{
        return ResponseEntity.ok().body("")
    }

}