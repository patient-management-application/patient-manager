package us.shamenramen.patientmanager.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.shamenramen.patientmanager.models.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
//    No username is defined on the user object.
    User findByUsername(String username);
//    User findByEmail(String email);
    User findById(long id);

    List<User> findByIsDoctor(boolean isDoctor);

    @Query(value = "SELECT * FROM users AS doc INNER JOIN users AS pat ON doc.id = pat.my_doc_id WHERE pat.my_doc_id = ?", nativeQuery = true)
    User findByMyDocId(long id);

    @Query(value = "SELECT * FROM users WHERE my_doc_id = ?", nativeQuery = true)
    List<User> findPatientsByDoctorId(long id);
//    Iterable<Long> findById();

}
