package us.shamenramen.patientmanager.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.ReviewRepository;
import us.shamenramen.patientmanager.repositories.UserRepository;

@Controller
public class UserController {
    private PasswordEncoder passwordEncoder;
    private UserRepository userDao;
    private ReviewRepository revDao;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder, ReviewRepository revDao) {
        this.passwordEncoder = passwordEncoder;
        this.userDao = userDao;
        this.revDao = revDao;
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
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loggedInUser.getId());
        model.addAttribute("user", user);
        model.addAttribute("doctors", userDao.findByIsDoctor(true));
        model.addAttribute("reviews", revDao.findAll());
        return "patients/search_doctors";
    }

    @PostMapping(path = "/setdoctor")
    public String setDoctor(@ModelAttribute(name = "hiddenDocId") long doctorId){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loggedInUser.getId());
        user.setMyDocId(doctorId);
        userDao.save(user);
        return "redirect:/dashboard";
    }

    @PostMapping(path = "/setdoctor/{id}")
    public String setDoctorForm(@PathVariable(name = "id") long doctorId){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loggedInUser.getId());
        user.setMyDocId(doctorId);
        userDao.save(user);
        return "redirect:/dashboard";
    }


    @GetMapping(path = "/users/{id}/edit")
    public String edit(@PathVariable long id, Model viewModel) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(id != loggedInUser.getId()){
            return "redirect:/dashboard";
        }
        User user = userDao.findOne(id);
        viewModel.addAttribute("user", user);
        return "/patients/edit_my_registration";
    }

    @PostMapping(path = "/users/{id}/edit")
    public String userEdit(@PathVariable long id, @ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/dashboard";

    }
    @GetMapping("/about")
    public String aboutPage() {
        return "/about";
    }
}
