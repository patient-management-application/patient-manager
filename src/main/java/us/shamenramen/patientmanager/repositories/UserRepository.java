package us.shamenramen.patientmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import us.shamenramen.patientmanager.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}
