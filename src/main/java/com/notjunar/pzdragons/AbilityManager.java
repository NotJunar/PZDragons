package com.notjunar.pzdragons;

import org.bukkit.entity.Player;

public class AbilityManager {

    // Unlock an ability for a player
    public static void unlockAbility(Player player, String ability) {
        // Logic to unlock ability for the player
        PlayerManager.unlockAbility(player, ability);
        player.sendMessage("You unlocked the " + ability + " ability!");
    }

    // Execute ability for player
    public static void executeAbility(Player player, String ability) {
        if (PlayerManager.hasAbility(player, ability)) {
            switch (ability) {
                case "Leap":
                    // Execute leap ability
                    break;
                case "Shield":
                    // Execute shield ability
                    break;
                // Add more abilities as needed
                default:
                    player.sendMessage("Ability not implemented yet.");
            }
        } else {
            player.sendMessage("You haven't unlocked the " + ability + " ability.");
        }
    }
}
