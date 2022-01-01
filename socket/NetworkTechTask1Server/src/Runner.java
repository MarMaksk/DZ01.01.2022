import Entity.Match;
import Entity.User;
import Service.FigureOperartion;
import Service.MessageOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.*;

public class Runner {

    private static final int PORT = 8080;
    private static boolean human = false;
    private static User user1 = new User();
    private static User user2 = new User();
    private static final Match match = new Match(3);

    public static void main(String[] args) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        MessageOperation mop = new MessageOperation(user1, user2, match);
        FigureOperartion fop = new FigureOperartion(user1, user2, match);
        StonePaperScissors game = new StonePaperScissors(user1, user2, match, human);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Режим игры: " + (human ? "человек" : "компьютер"));
            while (i != match.getDuration()) {
                Socket socket = serverSocket.accept();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    i = game.stonePaperScissors(i, sb, mop, fop, in, out);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


