package com.notjunar.pzdragons;

import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;

public class PlayerManager {

    private static final Map<Player, Integer> playerLives = new HashMap<>();
    private static final Map<Player, Boolean> playerAbilities = new HashMap<>();

    // Track player eliminations
    public static void playerEliminated(Player player) {
        playerLives.put(player, playerLives.getOrDefault(player, 1) - 1);
    }

    // Check if player is alive
    public static boolean isPlayerAlive(Player player) {
        return playerLives.getOrDefault(player, 0) > 0;
    }

    // Unlock abilities for players
    public static void unlockAbility(Player player, String ability) {
        playerAbilities.put(player, true); // Example, should be based on the actual ability system
    }

    // Check if player has a specific ability
    public static boolean hasAbility(Player player, String ability) {
        return playerAbilities.getOrDefault(player, false);
    }
}
