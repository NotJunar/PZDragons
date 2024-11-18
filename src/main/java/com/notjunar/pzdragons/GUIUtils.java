package com.notjunar.pzdragons;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUIUtils {

    // Method to create a basic inventory menu with a title
    public static Inventory createInventory(String title, int size) {
        return Bukkit.createInventory(null, size, title);
    }

    // Method to create a clickable item in the inventory
    public static ItemStack createClickableItem(Material material, String displayName, String... lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(displayName);
            meta.setLore(java.util.Arrays.asList(lore));
            item.setItemMeta(meta);
        }
        return item;
    }

    // Method to add items to the inventory
    public static void addItemToInventory(Inventory inventory, ItemStack item, int slot) {
        inventory.setItem(slot, item);
    }
}
