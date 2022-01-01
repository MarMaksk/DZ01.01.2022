package Entity;

import java.time.LocalDateTime;

public class Match {
    private int duration;
    private int stage = 0;
    private int stone = 0;
    private int paper = 0;
    private int scissors = 0;
    private int userOneWin = 0;
    private int userTwoWin = 0;
    private LocalDateTime timeStart = LocalDateTime.now();
    private LocalDateTime timeEnd;

    public Match(int game) {
        this.duration = game * 5;
    }

    public String getPopularFigure() {
        if (stone > paper && stone > scissors)
            return "камень";
        if (paper > stone && paper > scissors)
            return "бумага";
        if (scissors > paper && scissors > stone)
            return "ножницы";
        return "не определена";
    }

    public String getNotPopularFigure() {
        if (stone < paper && stone < scissors)
            return "камень";
        if (paper < stone && paper < scissors)
            return "бумага";
        if (scissors < paper && scissors < stone)
            return "ножницы";
        return "не определена";
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getStone() {
        return stone;
    }

    public int getPaper() {
        return paper;
    }


    public int getScissors() {
        return scissors;
    }


    public int getUserOneWin() {
        return userOneWin;
    }


    public int getUserTwoWin() {
        return userTwoWin;
    }

    public void useStone() {
        this.stone++;
    }

    public void usePaper() {
        this.paper++;
    }

    public void useScissors() {
        this.scissors++;
    }

    public void userOneWin() {
        userOneWin++;
    }

    public void userTwoWin() {
        userTwoWin++;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }
}
