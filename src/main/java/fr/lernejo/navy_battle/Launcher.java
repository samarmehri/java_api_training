package fr.lernejo.navy_battle;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.net.http.HttpClient;

public class Launcher {

    public static void main(String[] args) throws IOException {
        int port;
        if (args.length < 1) {Scanner scan = new Scanner(System.in);System.out.println("Please enter a port : ");port = scan.nextInt();scan.close();}
        else
        {port = Integer.parseInt(args[0]);}
        final Map<String, String> gameSetting = new HashMap<>();gameSetting.put("id", UUID.randomUUID().toString());gameSetting.put("port", String.valueOf(port));Client client = new Client(HttpClient.newHttpClient());Server server = new Server(port, client, gameSetting );server.start();
        if (args.length == 2) {gameSetting.put("client_url", args[1]);client.start(args[1], gameSetting);}
    }
}
