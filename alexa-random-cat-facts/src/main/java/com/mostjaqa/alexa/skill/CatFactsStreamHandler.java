package com.mostjaqa.alexa.skill;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.mostjaqa.alexa.skill.handlers.FactIntentHandler;
import com.mostjaqa.alexa.skill.handlers.LaunchRequestHandler;


public class CatFactsStreamHandler extends SkillStreamHandler {

    public CatFactsStreamHandler() {
        super(getSkill());
    }

    private static Skill getSkill() {
        return Skills.standard().addRequestHandlers(
                new FactIntentHandler(),
                new LaunchRequestHandler())
                .build();
    }
}
