package com.mostjaqa.alexa.skill.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class FallBackIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("AMAZON.FallbackIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String title = "Cat Facts";
        String speechText = "Sorry, I don't know that. Would you like to hear a cat fact?";
        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard(title, speechText)
                .withReprompt(speechText)
                .build();
    }
}
