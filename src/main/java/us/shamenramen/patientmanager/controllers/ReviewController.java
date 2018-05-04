package us.shamenramen.patientmanager.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import us.shamenramen.patientmanager.models.Review;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.ReviewRepository;
import us.shamenramen.patientmanager.repositories.UserRepository;

@Controller
public class ReviewController {
    private ReviewRepository revDao;
    private UserRepository userDao;

    public ReviewController(ReviewRepository revDao, UserRepository userDao) {
        this.revDao = revDao;
        this.userDao = userDao;
    }

    //FIX
    //need to be able to pull sessions only for that specific user
    @GetMapping(path = "/myreview")
    public String showSession(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (revDao.findByPatientId(loggedInUser.getId()) != null){
            Review review = revDao.findByPatientId(loggedInUser.getId());
            model.addAttribute("review", review);
        } else {
            Review review = new Review();
            model.addAttribute("review", review);
        }

        return "/patients/patient_feedback";

    }

    @GetMapping("/reviews/{id}")
    public String show(@PathVariable long id, Model viewAndmodel) {
        Review review = revDao.findOne(id);
        viewAndmodel.addAttribute("review", review);
        return "/reviews/show";
    }

    @GetMapping("/reviews/create")
    public String showCreateForm(Model viewmodel) {
        Review review = new Review();
        viewmodel.addAttribute("review", review);
        return "/reviews/create";
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

    @GetMapping("reviews/{id}/edit")
    public String edit(@PathVariable long id, Model viewModel) {
        Review review = revDao.findOne(id);
        viewModel.addAttribute("review", review);
        return "/reviews/edit";
    }

    @PostMapping("/reviews/{id}/edit")
    public String handleEdit(@PathVariable long id, @ModelAttribute Review review) {
        Review originalReview = revDao.findOne(id);
        originalReview.setReview(review.getReview());
        originalReview.setRating(review.getRating());
        revDao.save(review);
        return "redirect:/reviews";

    }

    @PostMapping("/reviews/{id}/delete")
    public String delete(@PathVariable long id) {
        revDao.delete(id);
        return "redirect:/reviews";
    }
}
