package uk.ac.city.aczg919.fitness.services;

import uk.ac.city.aczg919.fitness.entites.Exercise;
import java.util.List;

/**
 * Interface to create the template for Exercise Service.
 * Appends, Gets exercises
 * Returns list of exercises
 */
public interface ExerciseService {

    void addExercise(Exercise exercise);
    Exercise getExercise(String exercise);
    List<Exercise> getExercises();

}
