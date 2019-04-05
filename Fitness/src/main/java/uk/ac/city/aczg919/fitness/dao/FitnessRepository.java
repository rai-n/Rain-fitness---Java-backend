package uk.ac.city.aczg919.fitness.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.city.aczg919.fitness.entites.FitnessUser;

/**
 * Interface to create the repository for Fitness service.
 * The primary key is Email is Key which is represented by a String datatype.
 */
@Repository
public interface FitnessRepository extends JpaRepository<FitnessUser, String> {

}
