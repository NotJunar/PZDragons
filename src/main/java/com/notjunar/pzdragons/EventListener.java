package com.notjunar.pzdragons;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Handle player join event
        event.getPlayer().sendMessage("Welcome to PZDragons!");
    }

    // Add more event handling methods as needed for your plugin
}
