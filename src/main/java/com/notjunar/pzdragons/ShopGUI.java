package com.notjunar.pzdragons;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShopGUI {

    public static void openShopMenu(Player player) {
        Inventory inventory = GUIUtils.createInventory("Shop", 9);  // 9-slot inventory

        // Create upgrade items based on prices in the config
        createShopItem(inventory, "Leap Upgrade", Material.DIAMOND_SWORD, ConfigManager.getShopUpgradePrice("leap"), 1);
        createShopItem(inventory, "Shield Upgrade", Material.DIAMOND_CHESTPLATE, ConfigManager.getShopUpgradePrice("shield"), 3);
        createShopItem(inventory, "Teleport Upgrade", Material.ENDER_PEARL, ConfigManager.getShopUpgradePrice("teleport"), 5);

        // Open the inventory for the player
        player.openInventory(inventory);
    }

    private static void createShopItem(Inventory inventory, String itemName, Material material, int price, int slot) {
        ItemStack upgradeItem = GUIUtils.createClickableItem(
                material,
                itemName,
                "Price: " + price + " points"
        );
        GUIUtils.addItemToInventory(inventory, upgradeItem, slot);
    }
}
