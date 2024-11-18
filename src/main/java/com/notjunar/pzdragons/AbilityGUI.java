package com.notjunar.pzdragons;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AbilityGUI {

    public static void openAbilityMenu(Player player) {
        Inventory inventory = GUIUtils.createInventory("Ability Selection", 9);  // 9-slot inventory

        // Loop through each ability in the config and create an item for it
        createAbilityItem(inventory, "Leap", Material.FEATHER, ConfigManager.getAbilityCost("leap"), ConfigManager.getAbilityCooldown("leap"), 1);
        createAbilityItem(inventory, "Shield", Material.SHIELD, ConfigManager.getAbilityCost("shield"), ConfigManager.getAbilityCooldown("shield"), 3);
        createAbilityItem(inventory, "Teleport", Material.ENDER_PEARL, ConfigManager.getAbilityCost("teleport"), ConfigManager.getAbilityCooldown("teleport"), 5);
        createAbilityItem(inventory, "Regenerate", Material.GOLDEN_APPLE, ConfigManager.getAbilityCost("regenerate"), ConfigManager.getAbilityCooldown("regenerate"), 7);

        // Open the inventory for the player
        player.openInventory(inventory);
    }

    private static void createAbilityItem(Inventory inventory, String ability, Material material, int cost, int cooldown, int slot) {
        ItemStack abilityItem = GUIUtils.createClickableItem(
                material,
                ability,
                "Cost: " + cost + " points",
                "Cooldown: " + cooldown + " seconds"
        );
        GUIUtils.addItemToInventory(inventory, abilityItem, slot);
    }
}
