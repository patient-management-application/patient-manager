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
            } else {
                return "/doctors/dashboard";
            }
        }
        if (validSess){
            Session sess = new Session();
            User patient = userDao.findById(id);
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
        return "redirect:/dashboard";
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
//            if (updatedSession.getImage() == null){
//                user.setImage(updatedSession.getImage());
//            } else {
//                user.setImage("https://pbs.twimg.com/profile_images/3543879283/1509e34005183da5ea4eb29150f341e5_400x400.jpeg");
//            }
            sessDao.save(sess);
        }
        return "redirect:/dashboard";
    }

//    @GetMapping("/sessions/{id}")
//    public String show(@PathVariable long id, Model viewAndmodel) {
//        Session session = sessDao.findOne(id);
//        viewAndmodel.addAttribute("session", session);
//        return "/sessions/show";
//    }
//
//    @GetMapping("/sessions/create")
//    public String showCreateForm(Model viewmodel) {
//        Session session = new Session();
//        viewmodel.addAttribute("session", session);
//        return "/sessions/create";
//    }
//
//    //Need to implement Auth and Validation before this can be used
//
////    @PostMapping("/sessions/create")
////    public String createSession(@Valid Session session, Errors validation, Model model) {
////
////        if (validation.hasErrors()) {
////            model.addAttribute("errors", validation);
////            model.addAttribute("session", session);
////            return "/sessions/create";
////        } else {
////            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////            post.setUser(loggedInUser);
////            sessDao.save(session);
////            return "redirect:/sessions";
////        }
////    }
//
//    @GetMapping("sessions/{id}/edit")
//    public String edit(@PathVariable long id, Model viewModel) {
//        Session session = sessDao.findOne(id);
//        viewModel.addAttribute("session", session);
//        return "/sessions/edit";
//    }
//
//    @PostMapping("/sessions/{id}/edit")
//    public String handleEdit(@PathVariable long id, @ModelAttribute Session session) {
//        Session originalSession = sessDao.findOne(id);
//        originalSession.setNotes(session.getNotes());
//        originalSession.setPrescriptions(session.getPrescriptions());
//        originalSession.setProcedures(session.getProcedures());
//        originalSession.setTimeStart(session.getTimeStart());
//        originalSession.setTimeEnd(session.getTimeEnd());
//        sessDao.save(session);
//        return "redirect:/appointments";
//
//    }
//
//    @PostMapping("/sessions/{id}/delete")
//    public String delete(@PathVariable long id) {
//        sessDao.delete(id);
//        return "redirect:/sessions";
//    }
//
//
//
//
}
