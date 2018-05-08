package us.shamenramen.patientmanager.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import us.shamenramen.patientmanager.models.Bill;
import us.shamenramen.patientmanager.models.ChargeRequest;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.UserRepository;

import java.util.Currency;

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







    @Value("${sk_test_JDCutAUR2DvZFbSiCtGvjC48}")
    private String stripePublicKey;

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        return "checkout";
    }
}
