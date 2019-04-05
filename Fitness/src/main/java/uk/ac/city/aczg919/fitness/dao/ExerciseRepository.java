package uk.ac.city.aczg919.fitness.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.city.aczg919.fitness.entites.Exercise;

/**
 * Interface to create the repository for Exercise service.
 * The primary key is Workout is Key which is represented by a String datatype.
 */
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, String> {
}
