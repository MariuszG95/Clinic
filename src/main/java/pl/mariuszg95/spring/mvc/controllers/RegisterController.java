package pl.mariuszg95.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mariuszg95.spring.core.services.UserService;
import pl.mariuszg95.spring.dto.RegisterFormDTO;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Iterator;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @Autowired
    public RegisterController(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping
    public String prepareForm(Model model) {
        model.addAttribute("registerFormDTO", new RegisterFormDTO());

        return "register";
    }

    @PostMapping
    public String register(@Valid RegisterFormDTO registerFormDTO, BindingResult bindingResult) {
        HashMap<String, String> errors = registerFormDTO.getErrors();
        if (registerFormDTO.getStringBirthDate().isEmpty()) {
            System.out.println("empty");
            errors.put("birthDate", "Nie może być puste!");
            return "register";
        }
        if (bindingResult.hasErrors()) {
            BeanPropertyBindingResult beanPropertyBindingResult = (BeanPropertyBindingResult) bindingResult.getModel()
                    .get("org.springframework.validation.BindingResult.registerFormDTO");
            Iterator<FieldError> iterator = beanPropertyBindingResult.getFieldErrors().iterator();
            while (iterator.hasNext()) {
                FieldError fieldError = iterator.next();
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return "register";
        }
        try {
            registerFormDTO.setBirthDate();
        } catch (NumberFormatException nfe) {
            errors.put("birthDate", "Nieprawidłowa data urodzenia!");
            return "register";
        }
        if (!registerFormDTO.getPassword().equals(registerFormDTO.getRepeatedPassword())) {
            errors.put("repeatedPassword", "Hasła nie są identyczne!");
            return "register";
        }
        if (userService.isLoginTaken(registerFormDTO.getLogin())) {
            errors.put("login", "Login jest już zajęty!");
            return "register";
        }

        registerFormDTO.setPassword(passwordEncoder.encode(registerFormDTO.getPassword()));
        userService.insertUser(registerFormDTO);

        return "home";
    }
}
