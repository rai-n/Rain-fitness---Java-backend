package uk.ac.city.aczg919.fitness.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.city.aczg919.fitness.entites.Exercise;
import uk.ac.city.aczg919.fitness.services.ExerciseService;

import java.util.List;

/***
 * Controller to add the mapping for /add /load /param and /statcount
 * It is used to add exercise service and retrieve it containing information regarding
 * which exercises are done by the user for their tracking
 */
@Controller
public class ExerciseController {
    Logger log = LoggerFactory.getLogger(ExerciseController.class);
    private ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService){
        this.exerciseService = exerciseService;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showAdd(){
        Exercise exercise = new Exercise();
        return new ModelAndView("add", "exercises", exercise);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAdd(Exercise exercise){
        exerciseService.addExercise(exercise);
        return "redirect:/load";
    }

    @RequestMapping(value = "/load")
    public ModelAndView load(){
        List<Exercise> exercises = exerciseService.getExercises();
        return new ModelAndView("load", "exercises", exercises);
    }


    @RequestMapping(value = "/param", method = RequestMethod.POST)
    public ModelAndView processParam(@RequestParam("val") String value ){
        log.info("The value is: " + value);
        return new ModelAndView("param", "value", value);
    }

    @RequestMapping(value = "/statcount", method = RequestMethod.GET)
    public ModelAndView getProfile(@RequestParam("workout") String workout){
        Exercise exercise = exerciseService.getExercise(workout);
        return new ModelAndView("statcount", "exercise", exercise);
    }


}
