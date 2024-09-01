package com.mindera.mindswap.supernaturals;


public class Main {
    public static void main(String[] args) {

        Player player1 = new Player("Pedro");
        Player player2 = new Player("Maria");

        Game monsterGame = new Game(player1, player2);
        // get the number of initial cards

        // after the starting number of cards send the number to list monsters
        player1.giveMonstersToPlayer(2);
        player2.giveMonstersToPlayer(2);

        // game start
        monsterGame.start();
    }
}
