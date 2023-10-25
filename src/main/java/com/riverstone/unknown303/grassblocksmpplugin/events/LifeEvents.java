package com.riverstone.unknown303.grassblocksmpplugin.events;

import com.riverstone.unknown303.grassblocksmpplugin.GrassBlockSMPPlugin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class LifeEvents implements Listener {
    private GrassBlockSMPPlugin pl;
    public LifeEvents(GrassBlockSMPPlugin plugin) {
        plugin = pl;
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        String playerName = player.getDisplayName();
        Bukkit.getLogger().info(playerName);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event, FileConfiguration lifeConfig) {
        GrassBlockSMPPlugin.getUniqueId(lifeConfig);
    }
}
