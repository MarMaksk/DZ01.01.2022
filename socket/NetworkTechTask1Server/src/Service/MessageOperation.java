package Service;

import Entity.Match;
import Entity.User;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class MessageOperation {
    private User user1;
    private User user2;
    private Match match;
    private static List<String> resultList = new LinkedList<>();

    public MessageOperation(User user1, User user2, Match match) {
        this.user1 = user1;
        this.user2 = user2;
        this.match = match;
    }

    public void clearStringBuilder(StringBuilder sbFirst, StringBuilder sbSecond) {
        sbFirst.delete(0, sbFirst.length());
        sbSecond.delete(0, sbSecond.length());
    }

    public void getFinalResults(StringBuilder sbRes) {
        sbRes.append("Резултаты первого раунда: ")
                .append(resultList.get(0))
                .append(". Результаты второго раунда: ")
                .append(resultList.get(1))
                .append(". Результаты третьего раунда: ")
                .append(resultList.get(2))
                .append(". В матче выиграл: ")
                .append(match.getUserOneWin() > match.getUserTwoWin() ?
                        "игрок 1" : "игрок 2")
                .append(". Самая популярная фигура ")
                .append(match.getPopularFigure())
                .append(". Самая непопулярная фигура ")
                .append(match.getNotPopularFigure());
    }

    public void getStageResult(StringBuilder sbRes) {
        sbRes.append("Игрок 1 использовал: камень ")
                .append(user1.getStone())
                .append(" раз. Ножницы: ")
                .append(user1.getScissors())
                .append(" раз. Бумагу:")
                .append(user1.getPaper())
                .append(" раз. Игрок 2 использовал: камень ")
                .append(user2.getStone())
                .append(" раз. Ножницы: ")
                .append(user2.getScissors())
                .append(" раз. Бумагу:")
                .append(user2.getPaper())
                .append(". Игра продлилась: ")
                .append(LocalDateTime.now().getSecond() - match.getTimeStart().getSecond())
                .append(" Победитель: ")
                .append(user1.getWin() > user2.getWin() ? "игрок 1" : "игрок 2");
        resultList.add(sbRes.toString());
    }
}
