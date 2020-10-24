package controller

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TemplateController {

    @GetMapping("/sanitycheck")
    fun sanityCheck(): ResponseEntity.BodyBuilder {
        return ResponseEntity.ok();
    }
}