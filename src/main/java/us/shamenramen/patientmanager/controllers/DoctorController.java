package us.shamenramen.patientmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import us.shamenramen.patientmanager.models.DoctorProfile;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.DoctorRepository;
import us.shamenramen.patientmanager.repositories.UserRepository;

@Controller
public class DoctorController {
    private DoctorRepository docDao;
    private UserRepository userDao;

    public DoctorController(DoctorRepository docDao, UserRepository userDao) {
        this.docDao = docDao;
        this.userDao = userDao;
    }

//    @GetMapping("/doctors")
//    public String index(Model viewAndmodel) {
//        //still needs tweeking, trial run
////        Iterable<DoctorProfile> doctors = docDao.findAll();
//        Iterable<User> doctors = docDao.findAll();
//        viewAndmodel.addAttribute("doctors", doctors);
//        return "/doctors/index";
//    }

    @GetMapping("/doctors/{id}")
    public String show(@PathVariable long id, Model viewAndmodel) {
        DoctorProfile doctor = docDao.findOne(id);
        viewAndmodel.addAttribute("doctor", doctor);
        return "/doctors/show";
    }

    @GetMapping("/doctors/create")
    public String showCreateForm(Model viewmodel) {
        DoctorProfile doctor = new DoctorProfile();
        viewmodel.addAttribute("doctor", doctor);
        return "/doctors/create";
    }

    //Need to implement Auth and Validation before this can be used

//    @PostMapping("/reviews/create")
//    public String createReview(@Valid Review review, Errors validation, Model model) {
//
//        if (validation.hasErrors()) {
//            model.addAttribute("errors", validation);
//            model.addAttribute("review", review);
//            return "/reviews/create";
//        } else {
//            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            post.setUser(loggedInUser);
//            revDao.save(review);
//            return "redirect:/reviews";
//        }
//    }

//    @GetMapping("doctors/{id}/edit")
//    public String edit(@PathVariable long id, Model viewModel) {
//        DoctorProfile doctor = docDao.findOne(id);
//        viewModel.addAttribute("doctor", doctor);
//        return "/doctors/edit";
//    }

//    @PostMapping("/doctors/{id}/edit")
//    public String handleEdit(@PathVariable long id, @ModelAttribute DoctorProfile doctor) {
//        DoctorProfile originalDoctorProfile = docDao.findOne(id);
//        originalDoctorProfile.setBiography(doctor.getBiography());
//        originalDoctorProfile.setEducation(doctor.getEducation());
//        docDao.save(doctor);
//        return "redirect:/doctors";
//
//    }

    @PostMapping("/doctors/{id}/delete")
    public String delete(@PathVariable long id) {
        docDao.delete(id);
        return "redirect:/doctors";
    }
}
