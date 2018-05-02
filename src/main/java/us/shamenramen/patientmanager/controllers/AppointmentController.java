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

    //may not need this as appointments will be based on doc_id${id} to pull
    // avaiable appointments for that specific doc
    @GetMapping("/appointments")
    public String index(Model viewAndmodel) {
        //need to find to that specific user/doctor
        Iterable<Appointment> appointments = aptDao.findAll();
        viewAndmodel.addAttribute("appointments", appointments);
        return "/appointments/index";
    }

    @GetMapping("/appointments/{id}")
    public String show(@PathVariable long id, Model viewAndmodel) {
        Appointment appointment = aptDao.findOne(id);
        viewAndmodel.addAttribute("appointment", appointment);
        return "/appointments/show";
    }

    @GetMapping("/appointments/create")
    public String showCreateForm(Model viewmodel) {
        Appointment appointment = new Appointment();
        viewmodel.addAttribute("appointment", appointment);
        return "/appointments/create";
    }

    //Need to implement Auth and Validation before this can be used

//    @PostMapping("/appointments/create")
//    public String createAppointment(@Valid Appointment appointment, Errors validation, Model model) {
//
//        if (validation.hasErrors()) {
//            model.addAttribute("errors", validation);
//            model.addAttribute("appointment", appointment);
//            return "/appointments/create";
//        } else {
//            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            post.setUser(loggedInUser);
//            ptDao.save(appointment);
//            return "redirect:/appointments";
//        }
//    }

//    @PostMapping("/appointments/create")
//    public String createNewAppointment(@ModelAttribute Appointment appointment) {
//        appointment.setId(userDao.findOne((long)3));
//        aptDao.save(appointment);
//        return "redirect:/posts";
//    }

    @GetMapping("appointments/{id}/edit")
    public String edit(@PathVariable long id, Model viewModel) {
        Appointment appointment = aptDao.findOne(id);
        viewModel.addAttribute("appointment", appointment);
        return "/appointments/edit";
    }

    @PostMapping("/appointments/{id}/edit")
    public String handleEdit(@PathVariable long id, @ModelAttribute Appointment appointment) {
        Appointment originalAppointment = aptDao.findOne(id);
        originalAppointment.setScheduledTime(appointment.getScheduledTime());
        originalAppointment.setStatusId(appointment.getStatusId());
        originalAppointment.setDateCreated(appointment.getDateCreated());
        aptDao.save(appointment);
        return "redirect:/appointments";

    }

    @PostMapping("/appointments/{id}/delete")
    public String delete(@PathVariable long id) {
        aptDao.delete(id);
        return "redirect:/appointments";
    }
}
