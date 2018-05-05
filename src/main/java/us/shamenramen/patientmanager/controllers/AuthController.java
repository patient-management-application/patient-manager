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

    @GetMapping(path = "/login")
    public String login(){
//        Error handling goes here
        return "/users/index";
    }

    @GetMapping(path = "/dashboard")
    public String showDashboard(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user == null){
            return "/login";
        }
        if (user.getIsDoctor()) {
            user.setDoctor(true);
            model.addAttribute("user", userDao.findById(user.getId()));
            return "/doctors/doctor_dashboard";
        } else {

            if (user.getMyDocId() != 0){
                System.out.println(userDao.findByMyDocId(user.getMyDocId()).getFirstName());
                model.addAttribute("doctor", userDao.findByMyDocId(user.getMyDocId()));
            }
            model.addAttribute("user", userDao.findById(user.getId()));
            return "/patients/patient_dashboard";
        }
    }
}
