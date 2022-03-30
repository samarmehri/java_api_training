package fr.lernejo.navy_battle;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.Executors;

public class Launcher {
    private static void startServer(int serverPort) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(serverPort), 0);
        httpServer.setExecutor(Executors.newSingleThreadExecutor());
        httpServer.createContext("/ping", new Ping());
        httpServer.start();
    }

    public static void main(String[] args) {
        int port;
        if (args.length < 1) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter port");
            port = scan.nextInt();
            scan.close();
        } else {
            port = Integer.parseInt(args[0]);
        }
        final Map<String, String> gameInfo = new HashMap<String, String>();
        gameInfo.put("id", UUID.randomUUID().toString());
        gameInfo.put("port", String.valueOf(port));
        Server server = new Server(port, gameInfo);
        try {
            server.serverInit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
