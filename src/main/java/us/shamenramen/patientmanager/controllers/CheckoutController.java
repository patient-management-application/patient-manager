package us.shamenramen.patientmanager.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import us.shamenramen.patientmanager.models.ChargeRequest;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.UserRepository;

@Controller
public class CheckoutController {

    private UserRepository userDao;

    public CheckoutController(UserRepository userDao){
        this.userDao = userDao;
    }

    @Value("pk_test_RKYkdOzVLnRjMLXkR3EXgjIg")
    private String stripePublicKey;

    @GetMapping("/checkout")
    public String checkout(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loggedInUser.getId());
        model.addAttribute("user", user);
        model.addAttribute("amount", 118); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.USD);
        return "patients/confirm_payment";
    }

}
