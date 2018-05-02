//package us.shamenramen.patientmanager.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import us.shamenramen.patientmanager.models.Session;
//import us.shamenramen.patientmanager.repositories.SessionRepository;
//import us.shamenramen.patientmanager.repositories.UserRepository;
//
//@Controller
//public class SessionController {
//    private SessionRepository sessDao;
//    private UserRepository userDao;
//
//    public SessionController(SessionRepository sessDao, UserRepository userDao) {
//        this.sessDao = sessDao;
//        this.userDao = userDao;
//    }
//
//
//
////    need to be able to pull sessions only for that specific user
//    @GetMapping("/sessions")
//    public String index(@PathVariable long user_id, Model viewAndmodel) {
//        //still needs tweeking, trial run
//        Iterable<Session> sessions = sessDao.findAll(userDao.findById(user_id));
//
//        viewAndmodel.addAttribute("sessions", sessions);
//        return "/sessions/index";
//    }
//
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
//}
