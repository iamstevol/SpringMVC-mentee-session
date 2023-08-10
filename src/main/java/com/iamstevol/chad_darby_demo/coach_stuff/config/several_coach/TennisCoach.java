package com.iamstevol.chad_darby_demo.coach_stuff.config.several_coach;

import com.iamstevol.chad_darby_demo.coach_stuff.config.several_coach.Coach;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "I am getting better in my tennis skill";
    }
}
