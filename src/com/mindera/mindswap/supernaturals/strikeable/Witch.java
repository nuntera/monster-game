package com.mindera.mindswap.supernaturals.strikeable;

import com.mindera.mindswap.supernaturals.Supernatural;

public class Witch extends Supernatural implements Strikeable {
    public Witch(String name, int health, int hitPower) {
        super(name, hitPower);
        setHealth(health);
    }

    @Override
    public void receiveDamage(int damage) {
        setHealth(getHealth() - damage / 2); // Witch takes half damage
        if (getHealth() < 0) {
            setHealth(0);
        }
    }
}