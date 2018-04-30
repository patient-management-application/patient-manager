package us.shamenramen.patientmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import us.shamenramen.patientmanager.models.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
