package uk.ac.city.aczg919.fitness.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.city.aczg919.fitness.entites.CollatedUser;
import uk.ac.city.aczg919.fitness.services.ProfileService;

@Controller
public class ProfileController {

    /**
     * The profile service which generates a "CollatedUser" object that contains references
     * to each of the domain objects (FitnessUser, Enroll, LoginHistory.
     *
     */
    private ProfileService profileService;

    /**
     * Constructor based dependency injection of the profile service.
     *
     * @param profileService
     */
    @Autowired
    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    /**
     * Controller method to respond to GET requests to the /profile endpoint.
     *
     * @return ModelAndView an object that returns the profile.html view combined with the data
     * for the current logged in user (user info, package, details)
     */
    @RequestMapping(value="/profile")
    public ModelAndView showProfile(){
        //Retrieves the currently used email of the user which has already been authorised.
        //This is used to generate a CollatedUser which contains details of all the Users.
        //Therefore, a model can be made to extract all of the users information to one view.
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        CollatedUser user = profileService.getProfile(email);
        return new ModelAndView("profile", "collatedUser", user);
    }
}
