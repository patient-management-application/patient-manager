package us.shamenramen.patientmanager.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import us.shamenramen.patientmanager.models.Session;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.SessionRepository;
import us.shamenramen.patientmanager.repositories.UserRepository;

import java.util.List;

@Controller
public class SessionController {
    private SessionRepository sessDao;
    private UserRepository userDao;

    public SessionController(SessionRepository sessDao, UserRepository userDao) {
        this.sessDao = sessDao;
        this.userDao = userDao;
    }


    @GetMapping(path = "/newsession/{id}")
    public String showSession(Model model, @PathVariable long id) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        boolean validSess = false;
        List<User> patients = userDao.findPatientsByDoctorId(loggedInUser.getId());
        for (User p : patients){
            if (p.getId() == id){
                validSess = true;
            }
        }
        if (validSess){
            Session sess = new Session();
            User patient = userDao.findById(id);
            User user = userDao.findById(loggedInUser.getId());
            model.addAttribute("user", user);
            model.addAttribute("sess", sess);
            model.addAttribute("patient", patient);
        }

        return "/doctors/new_session";

    }


    @PostMapping(path = "/newsession/{id}")
    public String newSession(@PathVariable long id, @ModelAttribute("sess") Session ns){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User patient = userDao.findById(id);
        Session newSession = new Session();
        newSession.setPatientId(patient.getId());
        newSession.setDoctorId(loggedInUser.getId());
        newSession.setTimeStart(ns.getTimeStart());
        newSession.setTimeEnd(ns.getTimeEnd());
        newSession.setNotes(ns.getNotes());
        newSession.setProcedures(ns.getProcedures());
        newSession.setPrescriptions(ns.getPrescriptions());
        sessDao.save(newSession);
        return "redirect:/showsessions/"+id;
    }

    @PostMapping(path = "/mysession")
    public String updateSession(@ModelAttribute("session") Session updatedSession){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (sessDao.findByDoctorId(loggedInUser.getId()) != null){
            Session sess = sessDao.findByDoctorId(loggedInUser.getId());
            sess.setNotes(updatedSession.getNotes());
            sess.setPrescriptions(updatedSession.getPrescriptions());
            sess.setProcedures(updatedSession.getProcedures());
            sess.setTimeStart(updatedSession.getTimeEnd());
            sess.setTimeEnd(updatedSession.getTimeEnd());
            sess.setPatientId(updatedSession.getPatientId());
            sessDao.save(sess);
        }
        return "redirect:/dashboard";
    }

}
