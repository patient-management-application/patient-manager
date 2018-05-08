package us.shamenramen.patientmanager.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(path ="/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "users/registration";
    }

    @PostMapping(path = "/register")
    public String createPatient(@ModelAttribute User user, @RequestParam(defaultValue = "false") boolean isDoctor){
        if (isDoctor){
            user.setImage("https://pbs.twimg.com/profile_images/3543879283/1509e34005183da5ea4eb29150f341e5_400x400.jpeg");
            user.setDoctor(true);
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/";
    }

    @GetMapping(path = "/search")
    public String searchDoctors(Model model){
        model.addAttribute("doctors", userDao.findByIsDoctor(true));
        return "patients/search_doctors";
    }

    @PostMapping(path = "/setdoctor/{doctorId}")
    public String setDoctor(@PathVariable long doctorId){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loggedInUser.getId());
        user.setMyDocId(doctorId);
        System.out.println("After setmydoc " + doctorId);
        System.out.println(user.getMyDocId());
        userDao.save(user);
        return "redirect:/dashboard";
    }


}
