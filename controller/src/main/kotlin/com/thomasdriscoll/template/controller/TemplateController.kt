package com.thomasdriscoll.template.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController;
import com.thomasdriscoll.template.service.TemplateService
import org.springframework.http.ResponseEntity

@RestController
class TemplateController(
        templateService : TemplateService
) {
    @GetMapping("/")
    fun sanityCheck(){
        return ResponseEntity.ok()
    }

}