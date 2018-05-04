package us.shamenramen.patientmanager.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.UserRepository;

@Controller
public class DoctorController {
    private UserRepository userDao;

    public DoctorController( UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping(path = "/mypractice")
    public String showHealth(Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDao.findById(loggedInUser.getId()) != null){
            User user = userDao.findById(loggedInUser.getId());
            model.addAttribute("user", user);
        }
        return "/doctors/my_practice";
    }

    @PostMapping(path = "/mypractice")
    public String updatePractice(@ModelAttribute("user") User updatedUser){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDao.findById(loggedInUser.getId()) != null){
            User user = userDao.findById(loggedInUser.getId());
            user.setLicenseId(updatedUser.getLicenseId());
            user.setBiography(updatedUser.getBiography());
            user.setAccolades(updatedUser.getAccolades());
            user.setEducation(updatedUser.getEducation());
            user.setExperience(updatedUser.getExperience());
            user.setPracticingField(updatedUser.getPracticingField());
            userDao.save(user);
            System.out.println(user.getExperience());
            System.out.println(user.getId());
        }
        return "redirect:/dashboard";
    }
}
