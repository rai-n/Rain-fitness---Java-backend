package uk.ac.city.aczg919.fitness.entites;

import java.util.List;
/**
 * Class with all the information on Fitness User and their enrollments and login history.
 * */
public class CollatedUser{

    private FitnessUser fitnessUser;
    private List<Enroll> enrolls;
    private List<LoginHistory> logins;

    public FitnessUser getFitnessUser() {
        return fitnessUser;
    }

    public void setFitnessUser(FitnessUser fitnessUser) {
        this.fitnessUser = fitnessUser;
    }

    public List<Enroll> getEnrolls() {
        return enrolls;
    }

    public void setEnrolls(List<Enroll> enrolls) {
        this.enrolls = enrolls;
    }

    public List<LoginHistory> getLogins() {
        return logins;
    }

    public void setLogins(List<LoginHistory> logins) {
        this.logins = logins;
    }
}
