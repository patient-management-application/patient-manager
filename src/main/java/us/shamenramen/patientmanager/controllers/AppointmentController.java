package us.shamenramen.patientmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import us.shamenramen.patientmanager.models.Appointment;
import us.shamenramen.patientmanager.repositories.AppointmentRepository;
import us.shamenramen.patientmanager.repositories.UserRepository;

@Controller
public class AppointmentController {

    private AppointmentRepository aptDao;
    private UserRepository userDao;

    public AppointmentController(AppointmentRepository aptDao, UserRepository userDao) {
        this.aptDao = aptDao;
        this.userDao = userDao;
    }

}
