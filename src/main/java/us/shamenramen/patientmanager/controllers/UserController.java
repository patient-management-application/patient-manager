package us.shamenramen.patientmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.QuestionnaireRepository;
import us.shamenramen.patientmanager.repositories.UserRepository;

@Controller
public class UserController {
    private UserRepository userDao;
    private QuestionnaireRepository quesDao;


    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/landing")
    public String showSignUpForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "index";
    }

//    @GetMapping("/patientRegistration")
//    public String patientSignUpForm(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "/patients/patient_registration";
//    }
//
//    @GetMapping("/patientHealthRegistration")
//    public String healthForm(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "/patients/my_health";
//    }
//
//
//    @GetMapping("/doctorRegistration")
//    public String doctorSignUpForm(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "/doctors/doctor_registration";
//    }
//
//    @GetMapping("/doctorPracticeRegistration")
//    public String practiceSignUpForm(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "/doctors/my_practice";
//    }





//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute User user) {
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        users.save(user);
//        return "redirect:/login";
//    }

//    @PostMapping("/patientRegistration")
//    public String registerPatient(@ModelAttribute User user) {
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        userDao.save(user);
//        return "redirect:/patients/my_health";
//    }
//
//    //work on the logic
//    @PostMapping("/patientHealthRegistration")
//    public String registerUserHealth(@ModelAttribute User user) {
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        quesDao.save(questionnaire);
//        return "redirect:/patients/patient_dashboard";
//    }
//
//    @PostMapping("/doctorPracticeRegistration")
//    public String registerDoctor(@ModelAttribute User user) {
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        userDao.save(user);
//        return "redirect:/doctors/my_practice";
//    }
//
//    @PostMapping("/doctorPracticeRegistration")
//    public String registerDoctorPractice(@ModelAttribute User user) {
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        userDao.save(user);
//        return "redirect:/doctors/doctor_dashboard";
//    }

}
