package us.shamenramen.patientmanager.controllers;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import us.shamenramen.patientmanager.models.ChargeRequest;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.UserRepository;
import us.shamenramen.patientmanager.services.StripeService;

@Controller
public class ChargeController {

    private UserRepository userDao;

    public ChargeController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @Autowired
    private StripeService paymentsService;

    @PostMapping("/charge")
    public String charge(@PathVariable long id, ChargeRequest chargeRequest, Model model) throws StripeException {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loggedInUser.getId());
        chargeRequest.setDescription("Patient Payment");
        chargeRequest.setCurrency(ChargeRequest.Currency.USD);
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("user", user);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "redirect:/dashboard";
    }

    @GetMapping("/redirecttodash")
    public String redirectToDash(){
        return "redirect:/dashboard";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "redirect:/dashboard";
    }
}
