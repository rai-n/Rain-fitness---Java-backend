package uk.ac.city.aczg919.fitness.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.city.aczg919.fitness.dao.EnrollRepository;
import uk.ac.city.aczg919.fitness.entites.Enroll;

/**
 * Class implementing the methods specified in EnrollService
 */
@Service
public class EnrollServiceImpl implements EnrollService {

    /**
     * The EnrollRepostiory for interacting with enroll entity in db
     */
    private EnrollRepository enrollRepository;

    /**
     * Constructor based dependency injection of the Enroll repository
     * @param enrollRepository
     */
    @Autowired
    public EnrollServiceImpl(EnrollRepository enrollRepository){
        this.enrollRepository = enrollRepository;
    }

    /**
     * Implemented method to append data using enroll repository
     *
     * @param enroll object that contains the enroll data
     */
    @Override
    public void makeEnrollment(Enroll enroll) {
        enrollRepository.save(enroll);
    }
}
