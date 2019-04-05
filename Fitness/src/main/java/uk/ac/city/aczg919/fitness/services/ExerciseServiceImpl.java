package uk.ac.city.aczg919.fitness.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.city.aczg919.fitness.entites.Exercise;
import uk.ac.city.aczg919.fitness.dao.ExerciseRepository;

import java.util.List;

/**
 * Service implementation to access the exercise repository and interact with it
 * using various services
 */
@Service
public class ExerciseServiceImpl implements ExerciseService {

    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void addExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    @Override
    public Exercise getExercise(String exercise) {
        return exerciseRepository.findById(exercise).get();
    }

    @Override
    public List<Exercise> getExercises(){
        return exerciseRepository.findAll();
    }
}
