package uk.ac.city.aczg919.fitness.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.city.aczg919.fitness.dao.FitnessRepository;
import uk.ac.city.aczg919.fitness.entites.FitnessUser;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    /**
     * The repository for Fitness data
     */
    private FitnessRepository fitnessRepository;

    /**
     * Constructor based dependency injection
     *
     * @param fitnessRepository The repository for fitness data
     */
    @Autowired
    public RegistrationServiceImpl(FitnessRepository fitnessRepository){
        this.fitnessRepository = fitnessRepository;
    }

    /**
     * Saves the Fitness User
     *
     * @param fitnessUser the Fitness User which is saved
     */
    @Override
    public void registerUser(FitnessUser fitnessUser) {
        fitnessRepository.save(fitnessUser);
    }
}
