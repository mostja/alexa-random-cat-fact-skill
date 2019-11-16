package com.mostjaqa.alexa.skill.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class FactIntentHandler implements RequestHandler {

    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("GetNewFactIntent"));
    }

    public Optional<Response> handle(HandlerInput handlerInput) {
        String title = "Cat Facts";
        String speechText = "Nastia told me, that " + getSpeechText();
        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard(title, speechText)
                .build();
    }

    private String getSpeechText(){
        Unirest.config().verifySsl(false);
        HttpResponse<JsonNode> jsonResponse = Unirest.get("https://catfact.ninja/fact")
                .header("accept", "application/json")
                .asJson();
        return jsonResponse.getBody().getObject().getString("fact");
    }
}
