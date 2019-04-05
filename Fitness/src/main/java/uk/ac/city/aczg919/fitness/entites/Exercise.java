package uk.ac.city.aczg919.fitness.entites;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * An Entity class with information to track the values for minutes spend,
 * sets and reps for a given workout.
 */
@Entity
public class Exercise {

    @Id
    private String workout;
    private int mins;
    private int sets;
    private int reps;


    public Exercise() {
    }

    public String getWorkout() {
        return workout;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }

    public int getMins() {
        return mins;
    }

    public void setMins(int mins) {
        this.mins = mins;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

}
