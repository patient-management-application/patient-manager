package us.shamenramen.patientmanager.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import us.shamenramen.patientmanager.models.Questionnaire;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.QuestionnaireRepository;
import us.shamenramen.patientmanager.repositories.UserRepository;

@Controller
public class QuestionnaireController {
    private QuestionnaireRepository quesDao;
    private UserRepository userDao;


    public QuestionnaireController(QuestionnaireRepository quesDao, UserRepository userDao) {
        this.quesDao = quesDao;
        this.userDao = userDao;
    }

    @GetMapping(path = "/myhealth")
    public String showHealth(Model model){

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loggedInUser.getId());
        if (quesDao.findByPatientId(loggedInUser.getId()) != null){
            Questionnaire quest = quesDao.findByPatientId(loggedInUser.getId());
            model.addAttribute("quest", quest);
        } else {
            Questionnaire quest = new Questionnaire();
            model.addAttribute("quest", quest);
        }
        model.addAttribute("user", user);

        return "/patients/my_health";

    }

    @PostMapping(path = "/myhealth")
    public String quest(Questionnaire quest){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(quesDao.findByPatientId(loggedInUser.getId()) != null){
            quesDao.delete(quesDao.findByPatientId(loggedInUser.getId()));
        }
        quest.setPat_id(loggedInUser.getId());
        quesDao.save(quest);
        return "redirect:/dashboard";
    }

}
