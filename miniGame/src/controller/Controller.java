package controller;

import java.util.ArrayList;

import player.Player;

public class Controller {
    private ArrayList<Player> players = new ArrayList<Player>();
    private int currentPlayer;
    private boolean gameOver;
    private int winner;

    public void calculateScore(int currentPlayer, int addScore) {
        Player nowPlayer = this.players.get(currentPlayer);
        int newScore = nowPlayer.getCurrentScore() + addScore;
        if (newScore > 21) {
            this.players.get(currentPlayer).setCurrentScore(0);
        } else if (newScore == 21) {
            this.gameOver = true;
            this.winner = currentPlayer;
        } else {
            nowPlayer.setCurrentScore(newScore);
        }
    }

    public Controller() {
        this.currentPlayer = 0;
        this.gameOver = false;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }
}
