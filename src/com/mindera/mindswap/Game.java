package com.mindera.mindswap;

import com.mindera.mindswap.supernaturals.strikeable.monsters.Monster;
import com.mindera.mindswap.supernaturals.Supernatural;
import com.mindera.mindswap.supernaturals.NonAttackable;
import com.mindera.mindswap.supernaturals.fairies.Fairy;
import com.mindera.mindswap.supernaturals.strikeable.Strikeable;
import com.mindera.mindswap.supernaturals.strikeable.Witch;

import java.util.Random;
import static com.mindera.mindswap.Constants.*;

public class Game {
    private final Player player1;
    private final Player player2;
    private final Random random;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        random = new Random();
    }

    public void start() {
        System.out.println("Starting the game!");

        while (true) {
            // Check if any player has lost all monsters
            if (!player1.hasPlayableMonsters()) {
                System.out.println("Player 2 wins!");
                break;
            }
            if (!player2.hasPlayableMonsters()) {
                System.out.println("Player 1 wins!");
                break;
            }

            // Play one round
            playRound();
        }
    }

    private boolean shouldGenerateObstacle() {
        return random.nextDouble() <= 0.3; // 30% chance of obstacle
    }

    private Supernatural generateObstacle() {
        if (random.nextDouble() < 0.5) {  // 50% chance for each type
            return new Witch("Forest Witch", WITCH_HEALTH, WITCH_ATTACK_DAMAGE);
        } else {
            return new Fairy("Forest Fairy", FAIRY_ATTACK_DAMAGE);
        }
    }

    private void playRound() {
        if (shouldGenerateObstacle()) {
            handleObstacleRound();
        } else {
            handlePlayerVsPlayerRound();
        }
    }

    private void handleObstacleRound() {
        Supernatural obstacle = generateObstacle();
        System.out.println("A " + obstacle.getClass().getSimpleName() + " appears!");
        
        // Use NonAttackable interface to check if obstacle can be attacked
        if (obstacle instanceof NonAttackable) {
            handleNonAttackableObstacle(obstacle);
        } else {
            handleStrikeableObstacle((Strikeable) obstacle);
        }
    }

    private void handleNonAttackableObstacle(Supernatural obstacle) {
        // Non-attackable obstacles can only attack, never be attacked
        Player targetPlayer = random.nextBoolean() ? player1 : player2;
        Monster defendingMonster = targetPlayer.getRandomMonster();
        
        int attackDamage = obstacle.attack();
        defendingMonster.receiveDamage(attackDamage);
        
        System.out.println(obstacle + " attacks " + defendingMonster.getMonsterType() + 
                " for " + attackDamage + " damage. Remaining health: " + 
                defendingMonster.getHealth());
    }

    private void handleStrikeableObstacle(Strikeable obstacle) {
        // Randomly decide if obstacle attacks or is attacked
        if (random.nextBoolean()) {
            // Obstacle attacks random player
            Player targetPlayer = random.nextBoolean() ? player1 : player2;
            Monster defendingMonster = targetPlayer.getRandomMonster();
            
            int attackDamage = ((Supernatural) obstacle).attack();
            defendingMonster.receiveDamage(attackDamage);
            
            System.out.println(((Supernatural) obstacle) + " attacks " + defendingMonster.getMonsterType() + 
                    " for " + attackDamage + " damage. Remaining health: " + 
                    defendingMonster.getHealth());
        } else {
            // Random player attacks obstacle
            Player attackingPlayer = random.nextBoolean() ? player1 : player2;
            Monster attackingMonster = attackingPlayer.getRandomMonster();
            
            int attackDamage = attackingMonster.attack();
            obstacle.receiveDamage(attackDamage);
            
            System.out.println(attackingMonster.getMonsterType() + " attacks " + ((Supernatural) obstacle) +
                    " for " + attackDamage + " damage. Remaining health: " + 
                    obstacle.getHealth());
        }
    }

    private void handlePlayerVsPlayerRound() {
        // Randomly select attacker and defender
        Player attackingPlayer = random.nextBoolean() ? player1 : player2;
        Player defendingPlayer = (attackingPlayer == player1) ? player2 : player1;

        Monster attackingMonster = attackingPlayer.getRandomMonster();
        Monster defendingMonster = defendingPlayer.getRandomMonster();

        attackingPlayer.playMonster(attackingMonster);
        defendingPlayer.playMonster(defendingMonster);

        int attackDamage = attackingMonster.attack();
        defendingMonster.receiveDamage(attackDamage);

        System.out.println(attackingMonster.getMonsterType() + " attacks " +
                defendingMonster.getMonsterType() + " for " + attackDamage +
                " damage. Remaining health: " + defendingMonster.getHealth());
    }
} 