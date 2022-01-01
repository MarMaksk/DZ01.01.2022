package Service;

import Entity.Match;
import Entity.User;

public class FigureOperartion {
    private User user1;
    private User user2;
    private Match match;

    public FigureOperartion(User user1, User user2, Match match) {
        this.user1 = user1;
        this.user2 = user2;
        this.match = match;
    }

    public void setFigure(String answer, String message) {
        figure(message, user1);
        figure(answer, user2);
    }

    private void figure(String message, User user) {
        if (message.equals("камень")) {
            user.useStone();
            match.useStone();
        }
        if (message.equals("бумага")) {
            user.usePaper();
            match.usePaper();
        }
        if (message.equals("ножницы")) {
            user.useScissors();
            match.useScissors();
        }
    }
}
