package us.shamenramen.patientmanager.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.shamenramen.patientmanager.models.Appointment;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {


    @Query(value = "SELECT a.* , u.first_name, u.last_name FROM appointments a JOIN users u ON a.pat_id = u.id WHERE a.doc_id = ?", nativeQuery = true)
    List<Appointment> findPatientAppointmentsByDoctorId(long doctorId);

    Appointment findById(long id);

    @Query(value = "SELECT * FROM appointments WHERE doc_id = ?", nativeQuery = true)
    List<Appointment> findAppointmentByDoctorId(long doctorId);
}
