package us.shamenramen.patientmanager.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import us.shamenramen.patientmanager.models.Appointment;
import us.shamenramen.patientmanager.models.User;
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
    Iterable<Appointment> viewAllAppointmentsInJSONFormat(@RequestParam(name = "docId") long doctorId) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loggedInUser.getId());
        if (user.getIsDoctor()){
            return aptDao.findPatientAppointmentsByDoctorId(doctorId);
        } else {
            return aptDao.findAppointmentByDoctorId(doctorId);
        }
    }

    @GetMapping("/appointments/ajax")
    public String viewAllAdsWithAjax() {
        return "/appointments/ajax";
    }

    @PostMapping("/appointments/delete")
    public String deleteAppointment(@RequestParam(name = "id") long id){
        aptDao.delete(aptDao.findById(id));
        return "redirect:/dashboard";
    }

    @PostMapping("/appointments/ajax")
    public String makeAppointment(@RequestParam(name = "doctorId") long doctorId,
                                  @RequestParam(name = "patientId") long patientId,
                                  @RequestParam(name = "date") String date,
                                  @RequestParam(name = "time") String time,
                                  @RequestParam(name = "statusId") String statusId,
                                  @RequestParam(name = "patientName") String patientName,
                                  @RequestParam(name = "doctorName") String doctorName){

        Appointment app = new Appointment(
                patientId,
                doctorId,
                time,
                Integer.parseInt(statusId),
                date,
                patientName,
                doctorName);
        aptDao.save(app);
        return "redirect:/dashboard";
    }


    @PostMapping("/newappointment")
    public String doctorCreateAppointment(@RequestParam(name = "doctorId") long doctorId,
                                          @RequestParam(name = "patientId") long patientId,
                                          @RequestParam(name = "time") String time,
                                          @RequestParam(name = "date") String date,
                                          @RequestParam(name = "statusId") String statusId,
                                          @RequestParam(name = "doctorName") String doctorName
                                          ){



        String patientName = userDao.findById(patientId).getFirstName() + " " + userDao.findById(patientId).getLastName();
        Appointment app = new Appointment(
                patientId,
                doctorId,
                time,
                Integer.parseInt(statusId),
                date,
                patientName,
                doctorName);
        aptDao.save(app);
        return "redirect:/dashboard";
    }

}
