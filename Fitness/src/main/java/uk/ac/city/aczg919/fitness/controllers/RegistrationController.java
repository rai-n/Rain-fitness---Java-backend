package uk.ac.city.aczg919.fitness.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.city.aczg919.fitness.entites.FitnessUser;
import uk.ac.city.aczg919.fitness.services.RegistrationService;

@Controller
public class RegistrationController {

    /**
     * The registration service which is used to save user information to the
     * database.
     */
    private RegistrationService registrationService;

    /**
     * Constructor based dependency injection of the registration service
     *
     * @param registrationService Used to link the bean to the Registration Service
     */
    @Autowired
    public RegistrationController (RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    /**
     * Controller method for responding to a GET request to the /register endpoint
     *
     * @return ModelAndView a view created from register.html backed by a FitnessUser object
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegistation(){
        FitnessUser fitnessUser = new FitnessUser();
        return new ModelAndView("register", "fitnessUser", fitnessUser);
    }

    /**
     * Root end point is used to point at /register because that is the root of the website
     * @return ModeAndView a view is created from register.html backed by a FitnessUser object
     */
    @RequestMapping (value = "/")
    public ModelAndView showHome(){
        FitnessUser fitnessUser = new FitnessUser();
        return new ModelAndView("register","fitnessUser",fitnessUser);
    }


    /**
     * Controller method to handle a POST request to the /register endpoint
     *
     * @param fitnessUser an object containing the data from the registration form
     * @return String a redirect to the profile page
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistation(FitnessUser fitnessUser){
        fitnessUser.setEnabled(Boolean.TRUE);
        fitnessUser.setAuthoritiy("ROLE_USER");
        registrationService.registerUser(fitnessUser);
        return "redirect:/profile";
    }

}
