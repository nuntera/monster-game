package com.mindera.mindswap.supernaturals.strikeable.monsters;

import static com.mindera.mindswap.Constants.*;
import static com.mindera.mindswap.supernaturals.strikeable.monsters.MonsterType.MUMMY;


public class Mummy extends Monster{
    private int attackCount;
    private int maxConsecutiveAttacks;
    private int unrollDamage;

    public Mummy() {
        super(MUMMY, MUMMY_NAME, MUMMY_HEALTH, MUMMY_ATTACK_DAMAGE);
        attackCount = 0;
        maxConsecutiveAttacks = MUMMY_MAX_CONSECUTIVE_ATTACKS;
        unrollDamage = MUMMY_UNROLL_DAMAGE;
    }


    public void displayDetails() {
        super.displayDetails();
        System.out.println("Attack count: " + attackCount);
        System.out.println("Bite health increase: " + maxConsecutiveAttacks);
        System.out.println("Unroll damage: " + unrollDamage);
    }

    @Override
    public int attack() {
        if (attackCount < maxConsecutiveAttacks) {
            attackCount++;
            return getAttackDamage();
        } else {
            receiveDamage(unrollDamage);
            attackCount = 0; // Reset attack count
            System.out.println("The mummy unrolls and loses " + unrollDamage + " health!");
            return 0; // Attack fails
        }
    }
}
