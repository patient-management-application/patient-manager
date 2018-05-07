package us.shamenramen.patientmanager.services;

import com.stripe.model.Order;
import us.shamenramen.patientmanager.models.User;

public interface PaymentService {
    public String createCustomer(User user);
    public void chargeCreditCard(Order order);
}
