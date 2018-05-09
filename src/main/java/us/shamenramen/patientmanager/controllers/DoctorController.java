package us.shamenramen.patientmanager.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import us.shamenramen.patientmanager.models.Questionnaire;
import us.shamenramen.patientmanager.models.Session;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.QuestionnaireRepository;
import us.shamenramen.patientmanager.repositories.SessionRepository;
import us.shamenramen.patientmanager.repositories.UserRepository;

import java.util.List;

@Controller
public class DoctorController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;
    private SessionRepository sessDao;
    private QuestionnaireRepository quesDao;

    public DoctorController(UserRepository userDao, PasswordEncoder passwordEncoder, SessionRepository sessDao, QuestionnaireRepository quesDao) {
        this.quesDao = quesDao;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.sessDao = sessDao;
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
            if (updatedUser.getImage() != null){
                user.setImage(updatedUser.getImage());
            } else {
                user.setImage("https://pbs.twimg.com/profile_images/3543879283/1509e34005183da5ea4eb29150f341e5_400x400.jpeg");
            }
            userDao.save(user);
        }
        return "redirect:/dashboard";
    }

    @GetMapping("doctors/{id}/edit")
    public String edit(@PathVariable long id, Model viewModel) {
        User doctor = userDao.findOne(id);
        viewModel.addAttribute("doctor", doctor);
        return "/doctors/edit_doctor_registration";
    }

    @PostMapping("/doctors/{id}/edit")
    public String doctorEdit(@PathVariable long id, @ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/dashboard";

    }

    @GetMapping("/showsessions/{id}")
    public String showPatientSessions(@PathVariable(name = "id") long id, Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loggedInUser.getId());
        User patient = userDao.findById(id);
        Questionnaire ques = quesDao.findByPatientId(id);
        List<Session> sessions = sessDao.findByPatientId(id);
        model.addAttribute("ques", ques);
        model.addAttribute("patient", patient);
        model.addAttribute("user", user);
        model.addAttribute("sessions", sessions);
        return "/doctors/patient_session";
    }

}
