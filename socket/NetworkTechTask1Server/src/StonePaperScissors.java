import Entity.Match;
import Entity.User;
import Service.FigureOperartion;
import Service.MessageOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class StonePaperScissors {
    private static final String winServer = "Сервер выиграл";
    private static final String winPlayer = "Игрок выиграл";
    private static final String loseServer = "Сервер проиграл";
    private static final String losePlayer = "Игрок проиграл";
    private static final String draw = "Ничья";
    private static final List<String> figure = List.of("камень", "ножницы", "бумага");
    private User user1;
    private User user2;
    private Match match;
    private boolean human;

    public StonePaperScissors(User user1, User user2, Match match, boolean human) {
        this.user1 = user1;
        this.user2 = user2;
        this.match = match;
        this.human = human;
    }

    public int stonePaperScissors(int i, StringBuilder sb, MessageOperation mop, FigureOperartion fop, BufferedReader in, PrintWriter out) throws IOException {
        if (i == 5 || i == 10) {
            user1 = new User();
            user2 = new User();
        }
        String answer;
        String message = in.readLine().toLowerCase(Locale.ROOT);
        if (human) {
            answer = new Scanner(System.in).nextLine().toLowerCase(Locale.ROOT);
        } else {
            answer = figure.get((int) (Math.random() * figure.size()));
        }
        sb.append(answer).append(" ");
        System.out.println(message);
        game(sb, answer, message, fop);
        i++;
        StringBuilder sbRes = new StringBuilder();
        if (i == 5 + (5 * match.getStage())) {
            match.setStage(match.getStage() + 1);
            mop.getStageResult(sbRes);
            if (match.getStage() == 3) {
                mop.getFinalResults(sbRes);
            }
        }
        System.out.println(sbRes);
        out.println(sb.toString() + " " + sbRes);
        mop.clearStringBuilder(sb, sbRes);
        return i;
    }

    private void game(StringBuilder sb, String answer, String message, FigureOperartion fop) {
        fop.setFigure(answer, message);
        if (message.equals(answer)) {
            System.out.println(draw);
            sb.append(draw);
        } else if (message.equals("бумага") && answer.equals("камень") ||
                message.equals("ножницы") && answer.equals("бумага") ||
                message.equals("камень") && answer.equals("ножницы")) {
            System.out.println(loseServer);
            user2.userWin();
            sb.append(winPlayer);
        } else if (message.equals("камень") && answer.equals("бумага") ||
                message.equals("бумага") && answer.equals("ножницы") ||
                message.equals("ножницы") && answer.equals("камень")) {
            System.out.println(winServer);
            user1.userWin();
            sb.append(losePlayer);
        }
    }
}
