package pl.mariuszg95.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visits")
public class VisitsController {

    @GetMapping
    public String doGet() {
        return "visits";
    }
}
