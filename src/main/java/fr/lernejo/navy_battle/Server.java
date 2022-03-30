package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.Map;


public class Server {
    private final int port;
    private final Map<String, String> gameInfo;
    public Server(int port, Client client, Map<String, String> gameInfo) {

        this.gameInfo = gameInfo;
        this.port = port;
    }

    public void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(this.port), 0);
        Game serverInitGame = new Game(gameInfo);

        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new Ping());
	 server.createContext("/api/game/game", serverInitGame);
        server.start();
    }
}

