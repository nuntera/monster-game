package com.mindera.mindswap.supernaturals.strikeable.monsters;

import com.mindera.mindswap.supernaturals.Supernatural;
import com.mindera.mindswap.supernaturals.strikeable.Strikeable;


public abstract class Monster extends Supernatural implements Strikeable {
    private MonsterType monsterType;
    private int health;
    private boolean isPlayed;

    public Monster(MonsterType monsterType, String name, int health, int attackDamage) {
        super(name, attackDamage);
        this.monsterType = monsterType;
        this.health = health;
        isPlayed = false;
    }

    public void play() {
        isPlayed = true;
    }


    public void displayDetails() {
        super.displayDetails();
        System.out.println("Health: " + this.health);
    }

    public void receiveDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }


    public MonsterType getMonsterType() {
        return monsterType;
    }

    public int getHealth() {
        return health;
    }

    public boolean isPlayed() {
        return isPlayed;
    }
}
