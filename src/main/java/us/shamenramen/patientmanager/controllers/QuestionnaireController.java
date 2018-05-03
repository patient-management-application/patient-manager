package us.shamenramen.patientmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import us.shamenramen.patientmanager.models.Questionnaire;
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

    //need to be able to pull only questionnaires that belong to that specific user
    @GetMapping("/questionnaires")
    public String index(Model viewAndmodel) {
        //need to be able to pull for that user
//        Iterable<Questionnaire> questionnaires = quesDao.findAll();
//        viewAndmodel.addAttribute("questionnaires", questionnaires);
        return "/questionnaires/index";
    }

    @GetMapping("/questionnaires/{id}")
    public String show(@PathVariable long id, Model viewAndmodel) {
        Questionnaire questionnaire = quesDao.findOne(id);
        viewAndmodel.addAttribute("questionnaire", questionnaire);
        return "/questionnaires/show";
    }

    @GetMapping("/questionnaires/create")
    public String showCreateForm(Model viewmodel) {
        Questionnaire questionnaire = new Questionnaire();
        viewmodel.addAttribute("questionnaire", questionnaire);
        return "/questionnaires/create";
    }

    //Need to implement Auth and Validation before this can be used

//    @PostMapping("/questionnaires/create")
//    public String createQuestionnaire(@Valid Questionnaire questionnaire, Errors validation, Model model) {
//
//        if (validation.hasErrors()) {
//            model.addAttribute("errors", validation);
//            model.addAttribute("session", session);
//            return "/questionnaires/create";
//        } else {
//            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            post.setUser(loggedInUser);
//            quesDao.save(questionnaire);
//            return "redirect:/questionnaires";
//        }
//    }

    @GetMapping("questionnaires/{id}/edit")
    public String edit(@PathVariable long id, Model viewModel) {
        Questionnaire questionnaire = quesDao.findOne(id);
        viewModel.addAttribute("questionnaire", questionnaire);
        return "/questionnaires/edit";
    }

    @PostMapping("/sessions/{id}/edit")
    public String handleEdit(@PathVariable long id, @ModelAttribute Questionnaire questionnaire) {
        Questionnaire originalQuestionnaire = quesDao.findOne(id);
        originalQuestionnaire.setHistory(questionnaire.getHistory());
        originalQuestionnaire.setMedications(questionnaire.getMedications());
        originalQuestionnaire.setAllergies(questionnaire.getAllergies());
        originalQuestionnaire.setExtra(questionnaire.getExtra());
        quesDao.save(questionnaire);
        return "redirect:/questionnaires";

    }

    @PostMapping("/questionnaires/{id}/delete")
    public String delete(@PathVariable long id) {
        quesDao.delete(id);
        return "redirect:/questionnaires";
    }

}
