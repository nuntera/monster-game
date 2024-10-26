package com.mindera.mindswap.supernaturals.strikeable.monsters;

import java.util.Random;

import static com.mindera.mindswap.supernaturals.Constants.*;
import static com.mindera.mindswap.supernaturals.strikeable.monsters.MonsterType.VAMPIRE;


public class Vampire extends Monster{
    private int biteHealthIncrease;
    private double biteChance;

    public Vampire() {
        super(VAMPIRE, VAMPIRE_NAME, VAMPIRE_HEALTH, VAMPIRE_ATTACK_DAMAGE);
        biteHealthIncrease = VAMPIRE_BITE_HEALTH_INCREASE;
        biteChance = VAMPIRE_BITE_CHANCE;
    }


    public void displayDetails() {
        super.displayDetails();
        System.out.println("Bite Health Increase: " + biteHealthIncrease);
        System.out.println("Bite Chance: " + biteChance);
    }

    @Override
    public int attack() {
        Random random = new Random();
        if (random.nextDouble() <= biteChance) {
            receiveDamage(-biteHealthIncrease);
            System.out.println("The vampire bites its enemy and gains " + biteHealthIncrease + " health!");
        }
        return getAttackDamage();
    }
}
