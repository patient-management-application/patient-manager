package us.shamenramen.patientmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.shamenramen.patientmanager.models.Session;

import us.shamenramen.patientmanager.models.User;


@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {
    @Override
    default Iterable<Session> findAll(Iterable<Long> iterable) {
        return null;
    }


    //hoping to pull session by user_id, still in trial, might not work
//    Iterable<Session> findAll(User byId);

}
