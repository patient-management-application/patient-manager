package us.shamenramen.patientmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String showLoginForm() {
//        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
//            return "redirect:/posts";
//        } else {
            return "users/login";
//        }
    }
}
