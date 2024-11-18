package com.notjunar.pzdragons;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class DragonManager {

    private static int currentWave = 1;
    private static int playersAlive = 0;
    private static boolean gameRunning = false;

    // Start a new game
    public static void startGame(int round) {
        currentWave = round;
        playersAlive = Bukkit.getOnlinePlayers().size();
        gameRunning = true;
        Bukkit.broadcastMessage(ChatColor.GREEN + "Game Started! Round: " + currentWave);

        // Spawn initial dragons for the first wave
        spawnDragons(currentWave);
    }

    // Force start game at a specific round (admin only)
    public static void forceStartGame(int round) {
        currentWave = round;
        Bukkit.broadcastMessage(ChatColor.GREEN + "Game force-started at round " + round);
        spawnDragons(currentWave);
    }

    // Spawn dragons based on the current wave
    private static void spawnDragons(int wave) {
        World world = Bukkit.getWorlds().get(0);  // Assuming only 1 world for simplicity
        int numDragons = wave;  // The number of dragons increases with wave number

        for (int i = 0; i < numDragons; i++) {
            EnderDragon dragon = world.spawn(world.getSpawnLocation(), EnderDragon.class);
            dragon.setCustomName(ChatColor.RED + "Dragon " + (i + 1));
            dragon.setCustomNameVisible(true);

            // Make dragons fly towards the island
            // This is where the logic for flying toward the island comes in
            // For now, let's just spawn them at a random location near the spawn

            dragon.setVelocity(dragon.getLocation().getDirection().multiply(0.5));  // Set direction of flight
        }

        // Start the wave countdown
        startWaveCountdown(wave);
    }

    // Countdown to the next wave or round
    private static void startWaveCountdown(int wave) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (playersAlive <= 0) {
                    endGame();
                    cancel();
                } else {
                    // Wait for the next wave to start based on number of players eliminated
                    if (playersAlive <= 0) {
                        endGame();
                        cancel();
                    }
                    // Increase wave number after a set amount of time
                    if (wave == currentWave) {
                        spawnDragons(currentWave);
                        currentWave++;
                    }
                }
            }
        }.runTaskLater(PZDragons.getInstance(), 120L);  // Delay next wave (adjust as needed)
    }

    // Shrink the island based on damage taken (dragons destroying blocks)
    public static void shrinkIsland() {
        // Integrate with WorldEdit/FAWE to shrink the island after a certain number of waves
        // Example: Remove a chunk or specific blocks after dragon impact
    }

    // Handle player eliminations
    public static void playerEliminated(Player player) {
        playersAlive--;
        if (playersAlive <= 0) {
            endGame();
        }
    }

    // End the game
    private static void endGame() {
        gameRunning = false;
        Bukkit.broadcastMessage(ChatColor.RED + "The game has ended!");
        // You can reset the map or regenerate it here (depends on WorldEdit/FAWE)
        regenerateMap();
    }

    // Regenerate the map at the end of the game
    private static void regenerateMap() {
        // Use WorldEdit/FAWE to regenerate the map after the game ends
        // Here you could use WorldEdit's API to regenerate a region (requires proper integration with WorldEdit/FAWE)
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldedit//regen");
    }

    // Getters and Setters for game state
    public static boolean isGameRunning() {
        return gameRunning;
    }

    public static void setGameRunning(boolean gameRunning) {
        DragonManager.gameRunning = gameRunning;
    }

    public static int getCurrentWave() {
        return currentWave;
    }

    public static void setCurrentWave(int currentWave) {
        DragonManager.currentWave = currentWave;
    }

    public static int getPlayersAlive() {
        return playersAlive;
    }

    public static void setPlayersAlive(int playersAlive) {
        DragonManager.playersAlive = playersAlive;
    }
}
