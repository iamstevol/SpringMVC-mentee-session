package com.iamstevol.chad_darby_demo.coach_stuff.config.rest;

import com.iamstevol.chad_darby_demo.coach_stuff.config.several_coach.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FastController {

    private Coach myCoach;

    //@Qualifier will take in a class that we want to undergo bean initialization out of several ones and the identifier
    //of the class name will start with a small letter, which id also called a bean id
    @Autowired
    public FastController(@Qualifier("aquatic") Coach theCoach) {
        myCoach = theCoach;
    }
    @Value("${team.name}")
    private String coachName;

    @GetMapping("/dailyworkout")
    public String sport() {
        return myCoach.getDailyWorkout();
    }



}
