package us.shamenramen.patientmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.shamenramen.patientmanager.models.DoctorProfile;

@Repository
public interface DoctorRepository extends CrudRepository<DoctorProfile, Long>{
    DoctorProfile findByDoctorId(long doctorId);
}
