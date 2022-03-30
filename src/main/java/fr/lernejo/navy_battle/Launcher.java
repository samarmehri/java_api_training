package fr.lernejo.navy_battle;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.*;


public class Launcher
{
    private static void startServer(int serverPort) throws IOException
    {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(serverPort), 0);
        httpServer.setExecutor(Executors.newSingleThreadExecutor());
        httpServer.createContext("/ping", new Ping());
        httpServer.start();
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0)
            return;
        int serverPort = Integer.parseInt(args[0]);
        System.out.println("Listening on port :" + serverPort);
        startServer(serverPort);
    }
}

