package com.mindera.mindswap.supernaturals;

import com.mindera.mindswap.supernaturals.strikeable.MonsterFactory;
import com.mindera.mindswap.supernaturals.strikeable.monsters.Monster;
import com.mindera.mindswap.supernaturals.strikeable.monsters.MonsterType;

import java.util.Random;


public class Player {
    private String name;
    private int monsterCount;
    private Random random;
    private Monster[] monsters;

    public Player(String name){
        this.name = name;
        monsterCount = 0;
        random = new Random();
    }


    public void giveMonstersToPlayer(int numberOfMonstersToPlay) {
        // Add monsters to player
        monsters = new Monster[numberOfMonstersToPlay];
        MonsterType[] array = MonsterType.values();

        for (int i = 0; i < monsters.length; i++) {
            MonsterType monsterType = array[random.nextInt(array.length)];
            monsters[i] = MonsterFactory.generate(monsterType);
        }
        monsterCount = monsters.length;
    }

    public Monster getRandomMonster() {
        if (monsterCount < 1 ) {
            throw new IllegalArgumentException("No Monsters left to play");
        }
        for (Monster monster : getMonsters()) {
            if (monster.isPlayed() && --monsterCount < 1) {
                    throw new IllegalArgumentException("No Monsters left to play");
                }
        }
        int randomIndex = random.nextInt(monsters.length);
        while (monsters[randomIndex].isPlayed()) {
            randomIndex = random.nextInt(monsters.length);
        }
        return monsters[randomIndex];
    }

    public void playMonster(Monster monster) {
        monster.play();
        System.out.println(monster.isPlayed());


    }


    public Monster[] getMonsters() {
        return monsters;
    }

    /*

    // get a random !isObstacle already filtered in class DECK on initializeDeck()
    public Card getRandomMonsterCard() {
        while (true) {
            int index = random.nextInt(cardCount);
            if (!cards[index].isPlayed()) {
                return cards[index];
            }
        }
    }

    public void displayCards() {
        System.out.println("Player " + name + " cards:");
        for (int i = 0; i < cardCount; i++) {
            cards[i].displayCardDetails();
            System.out.println();
        }
    }

    public void playCard(int cardIndex) {
        if (cardIndex >= 0 && cardIndex < cardCount && !cards[cardIndex].isPlayed()) {
            cards[cardIndex].play();
        } else {
            System.out.println("Invalid card index or card already played.");
        }
    }

    public void addCard(Card card) {
        if (cardCount < cards.length) {
            cards[cardCount++] = card;
        } else {
            System.out.println("Player's hand is full, cannot add more cards.");
        }
    }


    public String getName() {
        return name;
    }

    public Card[] getCards() {
        return cards;
    }

     */
}
