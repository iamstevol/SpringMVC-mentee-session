package com.iamstevol.chad_darby_demo.coach_stuff.config;

import com.iamstevol.chad_darby_demo.coach_stuff.config.several_coach.Coach;
import com.iamstevol.chad_darby_demo.coach_stuff.config.several_coach.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
Without the @Component anotation the @Configuration was used to achieve the same thing. A Bean was created using the @Bean annotation,
the bean is actually a java class that give itself to Spring to take care of its life cycle. This @Bean is very good for third party access
 */
@Configuration
public class SportCoach {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
