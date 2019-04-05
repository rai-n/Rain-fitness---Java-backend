package uk.ac.city.aczg919.fitness.services;

import uk.ac.city.aczg919.fitness.entites.FitnessUser;

/**
 * Interface to create the template for Registration Service.
 * Appends a fitness user
 */
public interface RegistrationService {

    void registerUser(FitnessUser fitnessUser);
}
