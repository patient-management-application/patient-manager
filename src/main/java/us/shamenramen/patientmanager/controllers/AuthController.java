package us.shamenramen.patientmanager.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import us.shamenramen.patientmanager.models.Session;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.SessionRepository;
import us.shamenramen.patientmanager.repositories.UserRepository;

import java.util.List;

@Controller
public class AuthController {
    private UserRepository userDao;
    private SessionRepository sessDao;

    public AuthController(UserRepository userDao, SessionRepository sessDao) {
        this.userDao = userDao;
        this.sessDao = sessDao;
    }

    @GetMapping(path = "/login")
    public String login(){
//        Error handling goes here
        return "/users/index";
    }

    @GetMapping(path = "/dashboard")
    public String showDashboard(Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loggedInUser.getId());
        if (user == null){
            return "/login";
        }
        if (user.getIsDoctor()) {
            user.setDoctor(true);
            model.addAttribute("user", userDao.findById(user.getId()));
            model.addAttribute("patients", userDao.findPatientsByDoctorId(user.getId()));
            return "/doctors/doctor_dashboard";
        } else {
            if (user.getMyDocId() != 0 ){
                User doctor = userDao.findByMyDocId(user.getMyDocId());
                System.out.println(doctor.getFirstName());
                model.addAttribute("doctor", doctor);
                List<Session> userSessions = sessDao.findByDoctorIdAndPatientId(doctor.getId(), user.getId());
                model.addAttribute("sessions", userSessions);
            }
            model.addAttribute("user", userDao.findById(user.getId()));
            System.out.println("User my doc ID= " + userDao.findById(user.getId()).getMyDocId());
            return "/patients/patient_dashboard";
        }
    }
}
