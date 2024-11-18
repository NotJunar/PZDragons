package com.notjunar.pzdragons;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GameGUI {

    public static void openGameMenu(Player player) {
        Inventory inventory = GUIUtils.createInventory("Game Selection", 9); // 9-slot inventory

        // Create the "Join Game" button
        ItemStack joinGame = GUIUtils.createClickableItem(
                Material.GREEN_WOOL,
                "Join Game",
                "Click to join a game."
        );

        // Create the "Spectate Game" button
        ItemStack spectateGame = GUIUtils.createClickableItem(
                Material.GRAY_WOOL,
                "Spectate Game",
                "Click to spectate a game."
        );

        // Add items to the inventory
        GUIUtils.addItemToInventory(inventory, joinGame, 3);  // Slot 3 for Join Game
        GUIUtils.addItemToInventory(inventory, spectateGame, 5);  // Slot 5 for Spectate Game

        // Open the inventory for the player
        player.openInventory(inventory);
    }
}
