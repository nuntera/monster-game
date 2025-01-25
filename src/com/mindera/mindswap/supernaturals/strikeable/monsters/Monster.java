package com.mindera.mindswap.supernaturals.strikeable.monsters;

import com.mindera.mindswap.supernaturals.Supernatural;
import com.mindera.mindswap.supernaturals.strikeable.Strikeable;

public abstract class Monster extends Supernatural implements Strikeable {
    private final MonsterType monsterType;
    private boolean isPlayed;

    protected Monster(MonsterType monsterType, String name, int health, int hitPower) {
        super(name, hitPower);
        this.monsterType = monsterType;
        setHealth(health);
        isPlayed = false;
    }

    @Override
    public void receiveDamage(int damage) {
        setHealth(getHealth() - damage);
        if (getHealth() < 0) {
            setHealth(0);
        }
    }

    public MonsterType getMonsterType() {
        return monsterType;
    }

    public boolean isPlayed() {
        return isPlayed;
    }

    public void play() {
        isPlayed = true;
    }

    public void displayDetails() {
        System.out.println("Type: " + monsterType);
        System.out.println("Health: " + getHealth());
        System.out.println("Hit Power: " + getHitPower());
        System.out.println("Is Played: " + isPlayed);
    }

    @Override
    public String toString() {
        return getName();
    }
}
