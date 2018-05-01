package us.shamenramen.patientmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.shamenramen.patientmanager.models.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
