package us.shamenramen.patientmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.shamenramen.patientmanager.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
//    No username is defined on the user object.
    User findByEmail(String email);
    User findById(long id);



//    Iterable<Long> findById();

}
