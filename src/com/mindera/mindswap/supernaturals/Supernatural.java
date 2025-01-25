package com.mindera.mindswap.supernaturals;

public abstract class Supernatural {
    private String name;
    private int hitPower;
    private int health;

    protected Supernatural(String name, int hitPower) {
        this.name = name;
        this.hitPower = hitPower;
        this.health = 100;
    }

    public int attack() {
        System.out.println(this + " is attacking!");
        return hitPower;
    }

    public String getName() {
        return name;
    }

    public int getHitPower() {
        return hitPower;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return name;
    }
}