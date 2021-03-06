package us.shamenramen.patientmanager.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.shamenramen.patientmanager.models.Session;

import java.util.List;


@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {

    @Query(value = "SELECT * FROM sessions WHERE doctor_id = ? AND patient_id = ?", nativeQuery = true)
    List<Session> findByDoctorIdAndPatientId(long doctorId, long patientId);
    Session findByDoctorId(long doctorId);

    @Query(value = "SELECT * FROM sessions WHERE patient_id = ?", nativeQuery = true)
    List<Session> findByPatientId(long id);
}
