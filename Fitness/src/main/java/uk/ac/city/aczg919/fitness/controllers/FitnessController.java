package uk.ac.city.aczg919.fitness.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * A controller which handles get request for static template /diet and /fitness.
 */
@Controller
public class FitnessController {


    /**
     * Controller method to handle a GET request to the /diet endpoint
     *
     * @return ModelAndView returns a view constructed from diet.html (no model required)
     */
    @RequestMapping(value = "/diet")
    public ModelAndView showDiet(){
        return new ModelAndView("diet");
    }

    /**
     * Controller method to handle a GET request to the /fitness endpoint
     *
     * @return ModelAndView returns a view constructed from fitness.html (no model required)
     */
    @RequestMapping(value = "/fitness")
    public ModelAndView showFitness(){
        return new ModelAndView("fitness");
    }

}
