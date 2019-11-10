package com.mostjaqa.alexa.skil.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class FactIntentHandler implements RequestHandler {

    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("GetNewFactIntent"));
    }

    public Optional<Response> handle(HandlerInput handlerInput) {
        String title = "Cat Facts";
        String primaryText = "I am Nastia, super whooper coder";
        return handlerInput.getResponseBuilder()
                .withSpeech(primaryText)
                .withSimpleCard(title, primaryText)
                .build();
    }
}
