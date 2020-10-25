package controller

import com.thomasdriscoll.template.TemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController;

@RestController
class TemplateController(private val templateService: TemplateService) {

    @GetMapping("/{name}")
    fun sanityCheck(@PathVariable name: String): ResponseEntity<String> {
        return ResponseEntity.ok().body(templateService.swearToMe(name));
    }
}