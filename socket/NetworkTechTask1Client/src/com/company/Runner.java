package com.company;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class Runner {

    private static final int PORT = 8080;

    private static final String serverIp = "127.0.0.1";
    private static boolean human = false;
    private static List<String> figure = List.of("камень", "ножницы", "бумага");
    private static int game = 3;

    public static void main(String[] args) {
        System.out.println("Режим игры: " + (human ? "человек" : "компьютер"));
        int i = 0;
        while (i != 5 * game) {
            try (Socket fromserver = new Socket(serverIp, PORT);
                 PrintWriter out = new PrintWriter(fromserver.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(fromserver.getInputStream()))) {
                String answer;
                if (human) {
                    answer = new Scanner(System.in).nextLine().toLowerCase(Locale.ROOT);
                } else {
                    answer = figure.get((int) (Math.random() * figure.size()));
                    System.out.println(answer);
                }
                out.println(answer);
                String message = in.readLine();
                System.out.println(message);
                i++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
