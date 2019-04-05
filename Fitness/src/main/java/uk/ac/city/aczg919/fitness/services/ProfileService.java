package uk.ac.city.aczg919.fitness.services;

import uk.ac.city.aczg919.fitness.entites.CollatedUser;

/**
 * Interface to create the template for Profile Service.
 * Returns CollatedUsed
 */
public interface ProfileService {

    CollatedUser getProfile(String email);
}
