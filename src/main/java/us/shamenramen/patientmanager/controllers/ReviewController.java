package us.shamenramen.patientmanager.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(path = "/myreview")
    public String showReview(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loggedInUser.getId());
        if (revDao.findByPatientId(user.getId()) != null){
            Review review = revDao.findByPatientId(user.getId());
            model.addAttribute("user", user);
            model.addAttribute("review", review);
        } else {
            Review review = new Review();
            model.addAttribute("user", user);
            model.addAttribute("review", review);
        }
        return "/patients/patient_feedback";
    }

    @PostMapping(path = "/myreview")
    public String newReview(
            @RequestParam(name = "patientId") long patientId,
            @RequestParam(name = "doctorId") long doctorId,
            @RequestParam(name = "review") String review,
            @RequestParam(name = "rating") int rating){

        Review prevReview = revDao.findByPatientId(patientId);
        if (prevReview != null){
            revDao.delete(prevReview);
        }
        Review newReview = new Review(patientId,doctorId, review, rating);
        revDao.save(newReview);
        return "redirect:/dashboard";
    }

    @PostMapping("/myreview/delete")
    public String delete(@RequestParam(name = "patientId") long patientId) {
        revDao.delete(revDao.findByPatientId(patientId));
        return "redirect:/myreview";
    }
}
