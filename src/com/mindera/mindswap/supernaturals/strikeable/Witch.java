package com.mindera.mindswap.supernaturals.strikeable;

import com.mindera.mindswap.supernaturals.Supernatural;
import com.mindera.mindswap.supernaturals.strikeable.monsters.Monster;


public class Witch extends Supernatural implements Strikeable{
    private int health;

    public Witch(String name, int health, int attackDamage) {
        super(name, attackDamage);
        this.health = health;
    }


    public void displayDetails() {
        super.displayDetails();
        /*
        System.out.println("Attack count: " + this.attackCount);
        System.out.println("Bite Health Increase: " + this.maxConsecutiveAttacks);
        System.out.println("Bite Chance: " + this.unrollDamage);

         */
    }

    @Override
    public void receiveDamage(int damage) {
        this.health -= damage / 2;
        if (this.health < 0) {
            this.health = 0;
        }
    }


    public int getHealth() {
        return health;
    }
}
