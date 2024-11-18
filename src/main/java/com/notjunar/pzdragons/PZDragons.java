package com.notjunar.pzdragons;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;  // Added import for Listener
import com.notjunar.pzdragons.EventListener;  // Import for EventListener
import com.notjunar.pzdragons.GameGUI;  // Import for GameGUI
import com.notjunar.pzdragons.AbilityGUI;  // Import for AbilityGUI
import com.notjunar.pzdragons.ShopGUI;  // Import for ShopGUI (if you have this class)

public class PZDragons extends JavaPlugin {

    private static PZDragons instance;

    @Override
    public void onEnable() {
        // Initialize the plugin instance
        instance = this;

        // Load configuration
        ConfigManager.loadConfig();

        // Register commands
        getCommand("pzdragons").setExecutor(new PZDragonsCommand());

        // Register listeners
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);

        // Log success
        getLogger().info(ChatColor.GREEN + "PZDragons plugin enabled successfully.");
    }

    @Override
    public void onDisable() {
        // Log when the plugin is disabled
        getLogger().info(ChatColor.RED + "PZDragons plugin disabled.");
    }

    // Get the plugin instance
    public static PZDragons getInstance() {
        return instance;
    }

    // Command Executor (Main command for handling plugin commands)
    public class PZDragonsCommand implements org.bukkit.command.CommandExecutor {

        @Override
        public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
            if (args.length == 0) {
                return false;
            }

            switch (args[0].toLowerCase()) {
                case "version":
                    // Show plugin version and creator details
                    sender.sendMessage(ChatColor.YELLOW + "Version B1.3");
                    sender.sendMessage(ChatColor.YELLOW + "Made By NotJunar");
                    sender.sendMessage(ChatColor.YELLOW + "Join the community: https://dsc.gg/joinjnmc");
                    break;

                case "forcestart":
                    // Admin command to force start a specific round
                    if (args.length == 2) {
                        try {
                            int round = Integer.parseInt(args[1]);
                            DragonManager.forceStartGame(round);
                        } catch (NumberFormatException e) {
                            sender.sendMessage(ChatColor.RED + "Invalid round number.");
                        }
                    } else {
                        sender.sendMessage(ChatColor.RED + "Usage: /pzdragons forcestart <round>");
                    }
                    break;

                case "game":
                    // Open game GUI (if implemented)
                    if (sender instanceof Player) {
                        GameGUI.openGameMenu((Player) sender);
                    } else {
                        sender.sendMessage(ChatColor.RED + "Only players can open the game menu.");
                    }
                    break;

                case "ability":
                    // Open abilities GUI (if implemented)
                    if (sender instanceof Player) {
                        AbilityGUI.openAbilityMenu((Player) sender);
                    } else {
                        sender.sendMessage(ChatColor.RED + "Only players can open the ability menu.");
                    }
                    break;

                case "shop":
                    // Open shop GUI (if implemented)
                    if (sender instanceof Player) {
                        ShopGUI.openShopMenu((Player) sender);
                    } else {
                        sender.sendMessage(ChatColor.RED + "Only players can open the shop menu.");
                    }
                    break;

                case "reload":
                    // Reload the plugin configurations
                    ConfigManager.loadConfig();
                    sender.sendMessage(ChatColor.GREEN + "Plugin reloaded.");
                    break;

                default:
                    sender.sendMessage(ChatColor.RED + "Unknown command.");
                    return false;
            }
            return true;
        }
    }
}
