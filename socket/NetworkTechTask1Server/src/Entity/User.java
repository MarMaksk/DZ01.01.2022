package Entity;

public class User {
    private int stone = 0;
    private int paper = 0;
    private int scissors = 0;
    private int win = 0;

    public int getStone() {
        return stone;
    }

    public int getWin() {
        return win;
    }

    public void userWin() {
        this.win++;
    }

    public void useStone() {
        this.stone++;
    }

    public int getPaper() {
        return paper;
    }

    public void usePaper() {
        this.paper++;
    }

    public int getScissors() {
        return scissors;
    }

    public void useScissors() {
        this.scissors++;
    }
}
