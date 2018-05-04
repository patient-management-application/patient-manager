package us.shamenramen.patientmanager.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.UserRepository;

@Controller
public class AuthController {
    private UserRepository userDao;

    public AuthController(UserRepository userDao){
        this.userDao = userDao;
    }

    @GetMapping("/login")
    public String showLoginForm() { return "/users/index"; }

    @GetMapping(path = "/dashboard")
    public String showProfile(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user == null){
            return "/users/index";
        } else if (user.getIsDoctor()) {
            user.setDoctor(true);
            model.addAttribute("user", userDao.findById(user.getId()));
            return "/doctors/doctor_dashboard";
        } else {
            model.addAttribute("user", userDao.findById(user.getId()));
            return "/patients/patient_dashboard";
        }
    }
}
