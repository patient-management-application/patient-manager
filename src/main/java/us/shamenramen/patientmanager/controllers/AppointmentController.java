package us.shamenramen.patientmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import us.shamenramen.patientmanager.models.Appointment;
import us.shamenramen.patientmanager.repositories.AppointmentRepository;
import us.shamenramen.patientmanager.repositories.UserRepository;

import java.util.List;

@Controller
public class AppointmentController {

    private AppointmentRepository aptDao;
    private UserRepository userDao;

    public AppointmentController(AppointmentRepository aptDao, UserRepository userDao) {
        this.aptDao = aptDao;
        this.userDao = userDao;
    }

    @GetMapping("/appointments.json")
    public @ResponseBody
    Iterable<Appointment> viewAllAdsInJSONFormat() {
        return aptDao.findAll();
    }

    @GetMapping("/appointments/ajax")
    public String viewAllAdsWithAjax() {
        return "appointments/ajax";
    }

    @PostMapping("/appointments/ajax")
    public String postTest(@RequestParam(name = "doctorId") long doctorId){
        System.out.println("DOCTOR ID IS!!!!! " + doctorId);

        return "redirect:/dashboard";
    }

}
