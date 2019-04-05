package uk.ac.city.aczg919.fitness.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.city.aczg919.fitness.entites.Enroll;
import uk.ac.city.aczg919.fitness.services.EnrollService;

@Controller
public class EnrollController {

    /**
     * The Enroll service which is used to save Enrollments to the
     * database.
     */
    private EnrollService enrollService;

    /**
     * Constructor based dependency injection of the enroll service
     *
      * @param enrollService
     */
    @Autowired
    public EnrollController(EnrollService enrollService){
        this.enrollService = enrollService;
    }

    /**
     * Controller method to handle a get request to the /enroll endpoint
     *
     * @return ModelAndView an object that combines the enroll.html page with a Enroll
     * object that can be filled out with enrollment data to be saved to the database.
     */
    @RequestMapping(value = "enroll", method = RequestMethod.GET)
    public ModelAndView showEnrollment(){
        Enroll enroll = new Enroll();
        return new ModelAndView("enroll", "enroll", enroll);
    }

    /**
     * Controller method to handle a post request to the /enroll endpoint
     *
     * @param enroll the enroll object that contains the the information to
     *                be saved to the database.
     * @return String a redirect to the profile page.
     */
    @RequestMapping (value = "enroll", method = RequestMethod.POST)
    public String processEnrollment(Enroll enroll){
        //Email is retrieved from the user which is currently logged on.
        //That email is then used to enroll to a course thus accessing data from another table.
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        enroll.setEmail(email);
        enrollService.makeEnrollment(enroll);
        return "redirect:/profile";
    }

}
