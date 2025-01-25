package com.mindera.mindswap.supernaturals.fairies;

import com.mindera.mindswap.supernaturals.Supernatural;
import com.mindera.mindswap.supernaturals.NonAttackable;

public class Fairy extends Supernatural implements NonAttackable {
    public Fairy(String name, int hitPower) {
        super(name, hitPower);
    }
}