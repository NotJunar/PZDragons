package com.notjunar.pzdragons;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

    private static final PZDragons plugin = PZDragons.getInstance();
    private static final FileConfiguration config = plugin.getConfig();

    // Load configuration values
    public static void loadConfig() {
        config.options().copyDefaults(true);
        plugin.saveConfig();
    }

    // Dragon Settings
    public static int getDragonHealth() {
        return config.getInt("dragon.health", 100);  // Default to 100
    }

    public static double getDragonSpeed() {
        return config.getDouble("dragon.speed", 1.0);  // Default to 1.0
    }

    public static int getDragonDamage() {
        return config.getInt("dragon.damage", 10);  // Default to 10
    }

    // Wave Settings
    public static int getWaveTimeLimit() {
        return config.getInt("wave.timeLimit", 300);  // Default to 300 seconds
    }

    public static int getDragonCount() {
        return config.getInt("wave.dragonCount", 5);  // Default to 5 dragons per wave
    }

    // Ability Settings
    public static int getAbilityCost(String ability) {
        return config.getInt("abilities." + ability + ".cost", 10);  // Default to 10 for all abilities
    }

    public static int getAbilityCooldown(String ability) {
        return config.getInt("abilities." + ability + ".cooldown", 20);  // Default to 20 seconds for all abilities
    }

    // Shop Settings
    public static int getShopUpgradePrice(String upgrade) {
        return config.getInt("shop." + upgrade + "UpgradePrice", 50);  // Default to 50 for all upgrades
    }

    // General Settings
    public static int getMaxPlayers() {
        return config.getInt("game.maxPlayers", 16);  // Default to 16 players
    }

    public static boolean isSoloModeEnabled() {
        return config.getBoolean("game.soloMode", true);  // Default to true for solo mode
    }

    public static boolean isTeamModeEnabled() {
        return config.getBoolean("game.teamMode", true);  // Default to true for team mode
    }

    public static int getRoundTimeLimit() {
        return config.getInt("game.roundTimeLimit", 600);  // Default to 600 seconds for round limit
    }
}
