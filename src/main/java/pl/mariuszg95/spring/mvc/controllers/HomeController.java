package pl.mariuszg95.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mariuszg95.spring.core.services.DoctorService;
import pl.mariuszg95.spring.core.services.SpecializationService;
import pl.mariuszg95.spring.core.services.UserService;
import pl.mariuszg95.spring.data.model.Doctor;
import pl.mariuszg95.spring.data.model.User;
import pl.mariuszg95.spring.dto.DoctorDTO;
import pl.mariuszg95.spring.dto.UserDTO;

import java.util.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    private DoctorService doctorService;
    private SpecializationService specializationService;

    @Autowired
    public HomeController(DoctorService doctorService, SpecializationService specializationService) {
        this.doctorService = doctorService;
        this.specializationService = specializationService;
    }

    @GetMapping
    public String doGet() {
        return "home";
    }

    @PostMapping
    public String post(Model model, @RequestParam String search) {

        String[] queries = search.split(" ");
        Set<DoctorDTO> doctorsFound = new HashSet<>();
        for (String query : queries) {
            doctorsFound.addAll(doctorService.searchByFirstNameOrLastNameOrSpecialization(query));
        }
        model.addAttribute("doctorsFound", doctorsFound);

        return "home";
    }
}
