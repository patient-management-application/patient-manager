package us.shamenramen.patientmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.shamenramen.patientmanager.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{
    Review findByPatientId(long patientId);

    //trial run method, trying to pull all reviews by one user_id
//    Iterable<Review> findAll(User user);
}
