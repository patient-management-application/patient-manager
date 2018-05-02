package us.shamenramen.patientmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.UserRepository;

@Controller
public class UserController {
    private UserRepository userDao;


    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/landing")
    public String showSignUpForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users/create_user";
    }



//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute User user) {
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        users.save(user);
//        return "redirect:/login";
//    }

}
