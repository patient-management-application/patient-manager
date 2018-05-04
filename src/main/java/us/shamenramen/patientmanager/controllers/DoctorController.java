package us.shamenramen.patientmanager.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import us.shamenramen.patientmanager.models.DoctorProfile;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.repositories.DoctorRepository;
import us.shamenramen.patientmanager.repositories.UserRepository;

@Controller
public class DoctorController {
    private DoctorRepository docDao;
    private UserRepository userDao;

    public DoctorController(DoctorRepository docDao, UserRepository userDao) {
        this.docDao = docDao;
        this.userDao = userDao;
    }

    @GetMapping("/doctors")
    public String index(Model viewAndmodel) {
        //still needs tweeking, trial run
//        Iterable<DoctorProfile> doctors = docDao.findAll();
        Iterable<DoctorProfile> doctors = docDao.findAll();
        viewAndmodel.addAttribute("doctors", doctors);
        return "/patients/search_doctors";
    }

    @GetMapping("/doctors/{id}")
    public String show(@PathVariable long id, Model viewAndmodel) {
        DoctorProfile doctor = docDao.findOne(id);
        viewAndmodel.addAttribute("doctor", doctor);
        return "/doctors/show";
    }



    @GetMapping(path = "/mypractice")
    public String showHealth(Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (docDao.findByDoctorId(loggedInUser.getId()) != null){
            DoctorProfile doctor = docDao.findByDoctorId(loggedInUser.getId());
            model.addAttribute("doctor", doctor);
        } else {
            DoctorProfile doctor = new DoctorProfile();
            model.addAttribute("doctor", doctor);
        }

        return "/doctors/my_practice";

    }

    @PostMapping(path = "/mypractice")
    public String quest(DoctorProfile doctor){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(docDao.findByDoctorId(loggedInUser.getId()) != null){
            docDao.delete(docDao.findByDoctorId(loggedInUser.getId()));
        }
        doctor.setDoctorId(loggedInUser.getId());
        docDao.save(doctor);
        return "redirect:/dashboard";
    }

    //Need to implement Auth and Validation before this can be used

//    @PostMapping("/myPractice")
//    public String createDoctor(DoctorProfile doctor, Model model) {
//
//
//            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            DoctorProfile.setUser(loggedInUser);
//            docDao.save(doctor);
//            return "redirect:/dashboard";
//
//    }

    //would need to go to the dashboard
    @GetMapping("doctors/{id}/edit/my_practice")
    public String editPractice(@PathVariable long id, Model viewModel) {
        DoctorProfile doctor = docDao.findOne(id);
        viewModel.addAttribute("doctor", doctor);
        return "/doctors/edit_my_practice";
    }

    @GetMapping("doctors/{id}/edit/my_basic_info")
    public String editBasicInfo(@PathVariable long id, Model viewModel) {
        DoctorProfile doctor = docDao.findOne(id);
        viewModel.addAttribute("doctor", doctor);
        return "/doctors/edit_my_basic_info";
    }

    //need one for basic info edit
    @PostMapping("/doctors/{id}/edit/my_practice")
    public String handleEdit(@PathVariable long id, @ModelAttribute DoctorProfile doctor) {
        DoctorProfile originalDoctorProfile = docDao.findOne(id);
        originalDoctorProfile.setBiography(doctor.getBiography());
        originalDoctorProfile.setLicenseId(doctor.getLicenseId());
        originalDoctorProfile.setEducation(doctor.getEducation());
        originalDoctorProfile.setPracticingField(doctor.getPracticingField());
        originalDoctorProfile.setExperience(doctor.getExperience());
        originalDoctorProfile.setAccolades(doctor.getAccolades());
//        originalDoctorProfile.setImage(doctor.getImage());
        docDao.save(doctor);
        return "redirect:/doctors/doctor_dashboard";

    }

    @PostMapping("/doctors/{id}/edit/my_basic_info")
    public String handleEdit(@PathVariable long id, @ModelAttribute User doctor) {
        User originalUser = userDao.findOne(id);
        originalUser.setFirstName(doctor.getFirstName());
        originalUser.setLastName(doctor.getLastName());
        originalUser.setPhoneNumber(doctor.getPhoneNumber());
        originalUser.setEmail(doctor.getEmail());
        originalUser.setPassword(doctor.getPassword());
        originalUser.setGender(doctor.getGender());
        originalUser.setDob(doctor.getDob());
        originalUser.setStreet(doctor.getStreet());
        originalUser.setCity(doctor.getCity());
        originalUser.setState(doctor.getState());
        originalUser.setzipcode(doctor.getzipcode());
//        originalUser.setImage(doctor.getImage());
        userDao.save(doctor);
        return "redirect:/doctors/doctor_dashboard";

    }

    @PostMapping("/doctors/{id}/delete")
    public String delete(@PathVariable long id) {
        docDao.delete(id);
        return "redirect:/doctors";
    }


}
