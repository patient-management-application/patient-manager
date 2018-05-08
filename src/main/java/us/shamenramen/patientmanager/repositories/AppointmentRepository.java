package us.shamenramen.patientmanager.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.shamenramen.patientmanager.models.Appointment;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    Appointment findById(long id);

    @Query(value = "SELECT * FROM appointments WHERE doc_id = ?", nativeQuery = true)
    List<Appointment> findAppointmentByDoctorId(long doctorId);
}
