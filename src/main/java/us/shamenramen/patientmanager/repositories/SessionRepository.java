package us.shamenramen.patientmanager.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.shamenramen.patientmanager.models.Session;

import java.util.List;


@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {
//    @Override
//    default Iterable<Session> findAll(Iterable<Long> iterable) {
//        return null;
//    }
    @Query(value = "SELECT * FROM sessions WHERE doctor_id = ? AND patient_id = ?", nativeQuery = true)
    List<Session> findByDoctorIdAndPatientId(long doctorId, long patientId);

    Session findByDoctorId(long doctorId);
    //hoping to pull session by user_id, still in trial, might not work
//    Iterable<Session> findAll(User byId);

}
