package uk.ac.city.aczg919.fitness.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ac.city.aczg919.fitness.dao.FitnessRepository;
import uk.ac.city.aczg919.fitness.dao.HistoryRepository;
import uk.ac.city.aczg919.fitness.entites.FitnessUser;
import uk.ac.city.aczg919.fitness.entites.LoginHistory;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Custom authentication service which includes recording login history
 * each time a user is authenticated.
 */
@Service
public class FitnessUserDetails implements UserDetailsService {


    /**
     * The repository for fitness user data.
     */
    private FitnessRepository fitnessRepository;
    /**
     * The repository for login history
     */
    private HistoryRepository historyRepository;

    /**
     * Constructo based dependency injection of repositories.
     *
     * @param fitnessRepository the fitness user repo
     * @param historyRepository the login history repo
     */
    @Autowired
    public FitnessUserDetails(FitnessRepository fitnessRepository, HistoryRepository historyRepository){
        this.fitnessRepository = fitnessRepository;
        this.historyRepository = historyRepository;
    }

    /**
     * The override fo the UserDetailsService method that validates a user. The methods finds the
     * user in the database based on the String s provided by the users login credentials (their email
     * address)
     *
     * @param s user's email address provided when logging in.
     * @return UserDetails an object representing the user including their password, account status and roles
     * @throws UsernameNotFoundException if the user cannot be found in the database
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        FitnessUser fitnessUser = fitnessRepository.findById(s).orElseThrow(()-> new UsernameNotFoundException("No matching user."));
        //Exception handling methods are used to retrieve login history. There if the match is not found,
        //An exception is thrown. Otherwise an object is saved to the database.


        //New object is created
        LoginHistory loginHistory = new LoginHistory();
        //Email is added to the login history object
        loginHistory.setEmail(fitnessUser.getEmail());
        //Time is added to the login history object
        loginHistory.setTime(LocalDateTime.now());

        //The object it self is saved to the repository
        historyRepository.save(loginHistory);
        //and a UserDetails object will be constructed and returned.

        //Authorisation is created for FitnessUser and such authorities are applied
        //The  ArrayList is created with GrantedAuthority Generics containing the different
        //authorities FitnessUser has access to.
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(fitnessUser.getAuthoritiy()));
        return new User(fitnessUser.getEmail(), fitnessUser.getPassword(), fitnessUser.getEnabled(),
                        true, true, true, authorities);

    }
}
