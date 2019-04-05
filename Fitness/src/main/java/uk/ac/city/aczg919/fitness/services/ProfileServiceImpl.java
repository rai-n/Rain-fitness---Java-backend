package uk.ac.city.aczg919.fitness.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ac.city.aczg919.fitness.dao.EnrollRepository;
import uk.ac.city.aczg919.fitness.dao.FitnessRepository;
import uk.ac.city.aczg919.fitness.dao.HistoryRepository;
import uk.ac.city.aczg919.fitness.entites.CollatedUser;
import uk.ac.city.aczg919.fitness.entites.Enroll;
import uk.ac.city.aczg919.fitness.entites.LoginHistory;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {


    /**
     * The repository for Fitness User data.
     */
    private FitnessRepository fitnessRepository;
    /**
     * The repository for Enrollment data.
     */
    private EnrollRepository enrollRepository;
    /**
     * The repository for Login History logs.
     */
    private HistoryRepository historyRepository;


    /**
     *
     * Constructor based dependency injection of repositories.
     *
     * @param fitnessRepository the fitness user repo
     * @param enrollRepository the enroll repo
     * @param historyRepository the login history repo
     */
    @Autowired
    public ProfileServiceImpl(FitnessRepository fitnessRepository,
                              EnrollRepository enrollRepository,
                              HistoryRepository historyRepository){
        this.fitnessRepository = fitnessRepository;
        this.enrollRepository = enrollRepository;
        this.historyRepository = historyRepository;
    }

    /**
     * Implementation that collates all the user details information
     * into one single class of CollatedUser.
     *
     * @param email the current user's email
     * @return CollatedUser a object that aggregates all the user's data.
     */
    @Override
    public CollatedUser getProfile(String email) {
        //A new user is created
        CollatedUser user = new CollatedUser();
        //Exceptions are caught and if there is no matching data, request is thrown.
        user.setFitnessUser(fitnessRepository.findById(email).orElseThrow(()-> new UsernameNotFoundException("No matching user found.")));
        //For all users, the email is checked for to check if there is a match and if so,
        //it is added onto the list of enrolled users.
        List<Enroll> enrolls = enrollRepository.findAll()
                .stream().filter(enroll -> enroll.getEmail().equals(email))
                .collect(Collectors.toList());
        user.setEnrolls(enrolls);
        //List with LoginHistory generics is also checked to see if there is a match for email in the db
        //if so, it is appended onto the list which is added on the login setup for user.
        List<LoginHistory> history = historyRepository.findAll()
                .stream().filter(loginHistory -> loginHistory.getEmail().equals(email))
                .collect(Collectors.toList());
        user.setLogins(history);
        return user;
    }
}
