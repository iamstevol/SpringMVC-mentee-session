package com.iamstevol.chad_darby_demo.coach_stuff.config.several_coach;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "The baddest baseball coach";
    }
}
