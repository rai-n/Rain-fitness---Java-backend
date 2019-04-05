package uk.ac.city.aczg919.fitness.entites;

import java.nio.file.attribute.UserPrincipal;

/**
 * An class which shows the current information regarding a given Fitness User
 */
public class FitnessUserPrincipal implements UserPrincipal {

    private FitnessUser fitnessUser;

    public FitnessUserPrincipal(FitnessUser fitnessUser){
        this.fitnessUser = fitnessUser;
    }

    @Override
    public String getName() {
        return fitnessUser.getEmail();
    }


}
