package fr.lernejo.navy_battle;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try {
            System.out.println("Server start at port " + port);
            new Server().start(port);
        } catch (IOException e) {
            e.printStackTrace();
        if (args.length < 1) {
            System.out.println("Entrez un port");
            return;
        }

        int port = Integer.parseInt(args[0]);
        Server server = new Server(port);
        server.start();
    }

