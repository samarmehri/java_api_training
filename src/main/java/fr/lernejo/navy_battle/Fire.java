package fr.lernejo.navy_battle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import fr.lernejo.navy_battle.Actions;
import fr.lernejo.navy_battle.QueryFire;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Map;

public class Fire implements HttpHandler {
    private final Map<String, String> gameInfo;

    public Fire(Map<String, String> gameInfo) {
        this.gameInfo = gameInfo;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        URI url = exchange.getRequestURI();

        QueryFire queryFire = new QueryFire(Actions.miss, true);
        String messageSend = objectMapper.writeValueAsString(queryFire);
        exchange.getResponseHeaders().add("Content-type", "application/json");
        exchange.sendResponseHeaders(HttpURLConnection.HTTP_ACCEPTED, messageSend.getBytes().length);
        exchange.getResponseBody().write(messageSend.getBytes());
    }
}

