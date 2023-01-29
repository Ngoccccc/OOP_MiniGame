package app;

import java.util.Scanner;

import controller.Controller;
import player.Player;

public class App {
    private int humanPlayer;
    private Controller controller;

    public App() {
        System.out.println("Nhap so luong nguoi choi (luu y > 0 va <5):");
        Scanner sc = new Scanner(System.in);
        int numberHumanPlayer = sc.nextInt();
        while (numberHumanPlayer > 4 || numberHumanPlayer < 1) {
            System.out.println("Nhap lai so nguoi choi");
            numberHumanPlayer = sc.nextInt();
        }
        sc.close();
        this.humanPlayer = numberHumanPlayer;
        this.controller = new Controller();
        Player p;
        for (int i = 1; i <= 4; i++) {
            if (i <= this.humanPlayer) {
                p = new Player(Integer.toString(i), false, i);
            } else {
                p = new Player(Integer.toString(i), true, i);
            }
            this.controller.getPlayers().add(p);
        }

        Player player;
        while (!this.controller.isGameOver()) {
            int currentPlayer = this.controller.getCurrentPlayer();
            if (currentPlayer >= 4) {
                currentPlayer %= 4;
                this.controller.setCurrentPlayer(currentPlayer);
            }
            player = this.controller.getPlayers().get(currentPlayer);
            int gieo = player.gieoSucSac();
            this.controller.calculateScore(currentPlayer, gieo);
            System.out.println("nguoi choi " + (currentPlayer + 1) + " gieo duoc " + gieo + " nut."
                    + " So diem hien tai:" + this.controller.getPlayers().get(currentPlayer).getCurrentScore());
            if (this.controller.isGameOver()) {
                System.out.println("nguoi choi " + Integer.toString(currentPlayer + 1) + " la nguoi chien thang");
            }

            this.controller.setCurrentPlayer(currentPlayer + 1);

        }
        for (int i = 0; i <= 3; i++) {
            if (i != this.controller.getWinner()) {
                this.controller.getPlayers().get(i).makeInu();
            }
        }

    }

    public static void main(String[] args) {
        new App();
    }
}
