package com.iamstevol.chad_darby_demo.coach_stuff.config.several_coach;

import com.iamstevol.chad_darby_demo.coach_stuff.config.several_coach.Coach;

public class SwimCoach implements Coach {
    @Override
    public String getDailyWorkout() {
     return "Freshest swimmer";
    }
}
