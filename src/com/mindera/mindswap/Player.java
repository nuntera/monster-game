package com.mindera.mindswap;

import com.mindera.mindswap.supernaturals.strikeable.monsters.Monster;
import com.mindera.mindswap.supernaturals.strikeable.monsters.MonsterType;
import com.mindera.mindswap.supernaturals.strikeable.monsters.Mummy;
import com.mindera.mindswap.supernaturals.strikeable.monsters.Vampire;
import com.mindera.mindswap.supernaturals.strikeable.monsters.Werewolf;
import java.util.Random;

public class Player {
    private String name;
    private int monsterCount;
    private Random random;
    private Monster[] monsters;

    public Player(String name) {
        this.name = name;
        monsterCount = 0;
        random = new Random();
    }

    public boolean hasPlayableMonsters() {
        for (Monster monster : monsters) {
            if (monster.getHealth() > 0) {
                return true;
            }
        }
        return false;
    }

    public void giveMonstersToPlayer(int numberOfMonstersToPlay) {
        monsters = new Monster[numberOfMonstersToPlay];
        MonsterType[] array = MonsterType.values();

        for (int i = 0; i < monsters.length; i++) {
            MonsterType monsterType = array[random.nextInt(array.length)];
            monsters[i] = generateMonster(monsterType);
        }
        monsterCount = monsters.length;
    }

    private Monster generateMonster(MonsterType type) {
        switch (type) {
            case WEREWOLF:
                return new Werewolf();
            case VAMPIRE:
                return new Vampire();
            case MUMMY:
                return new Mummy();
            default:
                throw new RuntimeException("Monster type not implemented");
        }
    }

    public Monster getRandomMonster() {
        if (!hasPlayableMonsters()) {
            throw new IllegalArgumentException("No monsters left alive to play");
        }

        int attempts = 0;
        int maxAttempts = monsters.length * 2; // Prevent infinite loop

        while (attempts < maxAttempts) {
            int randomIndex = random.nextInt(monsters.length);
            if (monsters[randomIndex].getHealth() > 0) {
                return monsters[randomIndex];
            }
            attempts++;
        }

        // Fallback: linear search for first alive monster
        for (Monster monster : monsters) {
            if (monster.getHealth() > 0) {
                return monster;
            }
        }

        throw new IllegalStateException("No alive monsters found");
    }

    public void playMonster(Monster monster) {
        monster.play();
    }

    public Monster[] getMonsters() {
        return monsters;
    }
}