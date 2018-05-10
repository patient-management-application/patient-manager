package us.shamenramen.patientmanager.controllers;

//import lombok.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import us.shamenramen.patientmanager.models.ChargeRequest;

@Controller
public class CheckoutController {


    @Value("pk_test_RKYkdOzVLnRjMLXkR3EXgjIg")
    private String stripePublicKey;

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.USD);
        return "/patients/billing";
    }

}
