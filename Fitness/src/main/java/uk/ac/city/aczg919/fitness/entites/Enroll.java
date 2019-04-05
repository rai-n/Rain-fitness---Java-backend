package uk.ac.city.aczg919.fitness.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * An Entity class with information to enroll to a package for a specific Fitness User entity
 */
@Entity
public class Enroll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long key;
    private String email;
    private String user;
    public Enroll(){}


    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

   
}
