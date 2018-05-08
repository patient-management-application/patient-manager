package us.shamenramen.patientmanager.controllers;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import us.shamenramen.patientmanager.models.Bill;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.UserRepository;

import java.util.Currency;

@Controller
public class BillingController {

    private UserRepository userDao;
//    @Autowired
//    private StripeService paymentsService;

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



//    @PostMapping("/charge")
//    public String charge(ChargeRequest chargeRequest, Model model)
//            throws StripeException {
//        chargeRequest.setDescription("Example charge");
//        chargeRequest.setCurrency(Currency.EUR);
//        Charge charge = paymentsService.charge(chargeRequest);
//        model.addAttribute("id", charge.getId());
//        model.addAttribute("status", charge.getStatus());
//        model.addAttribute("chargeId", charge.getId());
//        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
//        return "result";
//    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }
}
