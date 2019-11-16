package com.mostjaqa.alexa.skill;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.mostjaqa.alexa.skill.handlers.CancelandStopIntentHandler;
import com.mostjaqa.alexa.skill.handlers.FactIntentHandler;
import com.mostjaqa.alexa.skill.handlers.FallBackIntentHandler;
import com.mostjaqa.alexa.skill.handlers.HelpIntentHandler;
import com.mostjaqa.alexa.skill.handlers.LaunchRequestHandler;
import com.mostjaqa.alexa.skill.handlers.SessionEndedRequestHandler;


public class CatFactsStreamHandler extends SkillStreamHandler {

    public CatFactsStreamHandler() {
        super(getSkill());
    }

    private static Skill getSkill() {
        return Skills.standard().addRequestHandlers(
                new FactIntentHandler(),
                new CancelandStopIntentHandler(),
                new FallBackIntentHandler(),
                new HelpIntentHandler(),
                new SessionEndedRequestHandler(),
                new LaunchRequestHandler())
                .build();
    }
}
