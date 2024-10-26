package com.mindera.mindswap.supernaturals;

import com.mindera.mindswap.supernaturals.strikeable.monsters.Monster;

import java.util.Random;

public class Game {
    private final Player player1;
    private final Player player2;
    private final Random random;

    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        random = new Random();
    }


    public void start() {
        System.out.println("Starting the game!");

        System.out.println(player1.getMonsters().length);
        System.out.println(player2.getMonsters().length);

        Monster attackingMonster = player1.getRandomMonster();
        System.out.println(attackingMonster.getMonsterType());

        player1.playMonster(attackingMonster);
        int attackDamage = attackingMonster.getAttackDamage();


        Monster defendingMonster = player2.getRandomMonster();
        System.out.println(defendingMonster.getMonsterType());

        player2.playMonster(defendingMonster);
        defendingMonster.receiveDamage(attackDamage);
        defendingMonster.receiveDamage(attackDamage);

        System.out.println("Health " + defendingMonster.getHealth());


        //determineResult(attackingMonster, defendingMonster);


        Monster attackingMonster2 = player1.getRandomMonster();
        System.out.println(attackingMonster2.getMonsterType());
        player1.playMonster(attackingMonster2);

        Monster defendingMonster2 = player2.getRandomMonster();
        System.out.println(defendingMonster2.getMonsterType());
        player2.playMonster(defendingMonster2);


        //System.out.println(Arrays.toString(player1.getMonsters()));


        //distributeCardsTo(this.player1, this.player2);

        //performRound();

        //cardDeck.displayDeck();
        //this.player1.displayCards();
        //this.player2.displayCards();

    }


    private void performRound() {
        Player attacker = random.nextBoolean() ? player1 : player2;
        Player defender = attacker == player1 ? player2 : player1;

        //Card attackingCard = attacker.getRandomMonsterCard();
        //attackingCard.displayCardDetails();

        //Card attackingCard = attacker.getRandomMonsterCard();
        //attackingCard.displayCardDetails();

        //Card defendingCard = defender.getRandomMonsterCard();
        //defendingCard.displayCardDetails();

        //System.out.println(attackingCard.getMonster());
        //System.out.println(defendingCard.getMonster());

        /*
        int damage = attackingCard.getMonster().attack();
        System.out.println(damage);

        if (defendingCard.getMonster() instanceof Strikeable) {
            ((Strikeable) defendingCard).receiveDamage(damage);
            System.out.println(attacker.getName() + "'s " + attackingCard.getClass().getSimpleName() + " attacks " +
                    defender.getName() + "'s " + defendingCard.getClass().getSimpleName() + " for " + damage + " damage.");
            System.out.println(defender.getName() + "'s " + defendingCard.getClass().getSimpleName() + " now has " + ((Strikeable) defendingCard).getHealth() + " health.");
        } else {
            System.out.println(defender.getName() + "'s " + defendingCard.getClass().getSimpleName() + " cannot receive damage.");
        }

         */


        //defendingCard.getSupernatural()   //receiveDamage(damage);

        //Supernatural
        //int damage = attackingCard.attack();


        /*
        Card attackingCard = attacker.getRandomMonsterCard();
        Card defendingCard = defender.getRandomMonsterCard();

        Monster attackingMonster = (Monster) attackingCard.getBeing();
        Monster defendingMonster = (Monster) defendingCard.getBeing();

        int damage = attackingMonster.attack();
        defendingMonster.receiveDamage(damage);

        System.out.println(attacker.getName() + "'s " + attackingMonster.getType() + " attacks " + defender.getName() + "'s " + defendingMonster.getType() + " for " + damage + " damage.");
        System.out.println(defender.getName() + "'s " + defendingMonster.getType() + " now has " + defendingMonster.getHealth() + " health.");
         */
        // You can add conditions to remove cards when their health drops to 0, and also determine the end of the game.
    }

    /*

    private void distributeCardsTo(Player player1, Player player2, Deck cardDeck) {
        // Distribute cards to players
        Card[] cards = cardDeck.getCards();
        int halfDeckSize = cards.length / 2;

        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) {
                if (i < halfDeckSize){
                    player1.addCard(cards[i]);
                } else {
                    player2.addCard(cards[i]);
                }
            }
        }
    }

     */
}
