package com.mindera.mindswap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of monsters for each player:");
        int monsterCount = scanner.nextInt();

        Player player1 = new Player("Pedro");
        Player player2 = new Player("Maria");

        player1.giveMonstersToPlayer(monsterCount);
        player2.giveMonstersToPlayer(monsterCount);

        Game monsterGame = new Game(player1, player2);
        monsterGame.start();
    }
}
