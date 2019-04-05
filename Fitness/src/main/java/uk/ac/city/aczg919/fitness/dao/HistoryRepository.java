package uk.ac.city.aczg919.fitness.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.city.aczg919.fitness.entites.LoginHistory;

/**
 * Interface to create the repository for LoginHistory service.
 * The primary key is Enroll is Key which is represented by a String datatype.
 */
@Repository
public interface HistoryRepository extends JpaRepository<LoginHistory, String> {

}
