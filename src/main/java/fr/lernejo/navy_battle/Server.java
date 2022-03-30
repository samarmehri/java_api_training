package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server
{
    private final Map<String, String> gameSetting;private final Client client;private final int port;
    public Server(int port, Client client, Map<String, String> gameSetting)
    {this.gameSetting = gameSetting;this.port = port;this.client = client;}
    public void start()
    {
        InetSocketAddress socketAddr = new InetSocketAddress(port);ExecutorService executorService = Executors.newFixedThreadPool(1);
        try {HttpServer httpServer = HttpServer.create(socketAddr, 0);Game Game= new Game(gameSetting);System.out.println("Server start at port : " + port);httpServer.setExecutor(executorService);httpServer.createContext("/ping", new Ping());httpServer.createContext("/api/game/start", Game);httpServer.start();
        } catch (IOException e) {e.printStackTrace();}
    }
}
