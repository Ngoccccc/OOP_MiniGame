package player;

import dice.Dice;

public class Player {

    private String name;

    private int currentScore;
    private boolean isBot;
    private Dice dice;

    public Player(String name, boolean isBot, int luckyNumber) {
        this.name = name;
        this.currentScore = 0;
        this.isBot = isBot;
        this.dice = new Dice(luckyNumber);
    }

    public String getName() {
        return name;
    }

    public void makeInu() {
        if (this.isBot) {
            System.out.println("Bot da thua huhu");
        } else {
            System.out.println("Nguoi da thua haha");
        }
    }

    public int gieoSucSac() {
        return dice.getScore();
    }

    public static void main(String[] args) {
        Player p = new Player("Ngoc", false, 3);
        System.out.println(p.gieoSucSac());
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public boolean getIsBot() {
        return isBot;
    }

    public Dice getDice() {
        return dice;
    }

}
