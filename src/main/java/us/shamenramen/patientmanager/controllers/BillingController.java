package us.shamenramen.patientmanager.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import us.shamenramen.patientmanager.models.Bill;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.UserRepository;

@Controller
public class BillingController {

    private UserRepository userDao;

    public BillingController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping(path = "/mybilling")
    public String showBilling(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            Bill bill = new Bill();
            model.addAttribute("bill", bill);


        return "/doctors/billing";
    }
}
