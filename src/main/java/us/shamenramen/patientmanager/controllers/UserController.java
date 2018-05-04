package us.shamenramen.patientmanager.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.QuestionnaireRepository;
import us.shamenramen.patientmanager.repositories.UserRepository;

@Controller
public class UserController {
    private PasswordEncoder passwordEncoder;
    private UserRepository userDao;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userDao = userDao;
    }

    @GetMapping(path = "/index")
    public String showIndex(Model model){
        model.addAttribute("user", new User());
        return "/users/index";
    }
    @GetMapping(path = "/")
    public String showIndex2(Model model){
        model.addAttribute("user", new User());
        return "/users/index";
    }

//    @GetMapping(path = "/patient_registration")
//    public String getPatientReg(){
//        return "/patients/patient_registration";
//    }


    @PostMapping(path = "/register")
    public String createPatient(@ModelAttribute User user, @RequestParam(defaultValue = "false") boolean isDoctor){
        if (isDoctor){
            user.setDoctor(true);
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/";
    }


}
