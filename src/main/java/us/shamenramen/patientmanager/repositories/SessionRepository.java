package us.shamenramen.patientmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.shamenramen.patientmanager.models.Session;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {
    @Override
    default Iterable<Session> findAll(Iterable<Long> iterable) {
        return null;
    }
}
