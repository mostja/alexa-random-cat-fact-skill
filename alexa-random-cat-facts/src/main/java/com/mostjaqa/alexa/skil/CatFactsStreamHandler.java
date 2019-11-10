package com.mostjaqa.alexa.skil;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.mostjaqa.alexa.skil.handlers.FactIntentHandler;


public class CatFactsStreamHandler extends SkillStreamHandler {

    public CatFactsStreamHandler() {
        super(getSkill());
    }

    private static Skill getSkill() {
        return Skills.standard().addRequestHandler(new FactIntentHandler()).build();
    }
}
