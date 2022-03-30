package fr.lernejo.navy_battle;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

public class Game implements HttpHandler
{
    private final Map<String, String> gameSetting;
    public Game(Map<String, String> gameInfo) {
        this.gameSetting = gameInfo;
    }
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(); System.out.println(exchange.getRequestMethod());
        if (exchange.getRequestMethod().equals("POST")) {
            try {InputStream response = exchange.getRequestBody(); objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); Request requestReceive = objectMapper.readValue(response, Request
                .class); String messageRequest = requestReceive.getMessage(); gameSetting.put("client_id", requestReceive.getId());gameSetting.put("client_url", requestReceive.getUrl());System.out.println(messageRequest);System.out.println(gameSetting.get("id"));System.out.println(gameSetting.get("port"));System.out.println(gameSetting.get("client_id"));System.out.println(gameSetting.get("client_url"));}catch (IOException e) {exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);}
            Request requestSend = new Request(gameSetting.get("id"), "http://localhost:" + gameSetting.get("port"), "May the best code win");String messageSend = objectMapper.writeValueAsString(requestSend);exchange.sendResponseHeaders(HttpURLConnection.HTTP_ACCEPTED, messageSend.getBytes().length);exchange.getResponseBody().write(messageSend.getBytes());}
        else {exchange.sendResponseHeaders(HttpURLConnection.HTTP_NOT_FOUND, 0);}
    }
}
