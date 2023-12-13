package com.riverstone.unknown303.grassblocksmpplugin.events;

import com.codingforcookies.armorequip.ArmorEquipEvent;
import com.riverstone.unknown303.grassblocksmpplugin.GrassBlockSMPPlugin;
import com.riverstone.unknown303.grassblocksmpplugin.guis.UnbanScreen;
import com.riverstone.unknown303.grassblocksmpplugin.items.LifeItemsManager;
import org.bukkit.*;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LifeEvents implements Listener {
    public static List<OfflinePlayer> lifeBannedPlayers = new ArrayList<>();
    public static List<OfflinePlayer> emptyPlayers = new ArrayList<>();
    private GrassBlockSMPPlugin pl;
    private FileConfiguration newLifeConfig;
    private File newLifeConfigFile;
    public LifeEvents(FileConfiguration lifeConfig, File lifeConfigFile) {
        newLifeConfig = lifeConfig;
        newLifeConfigFile = lifeConfigFile;
        lifeConfig.addDefault("lifeBannedPlayers", emptyPlayers);
        try {
            lifeConfig.save(lifeConfigFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        String playerName = player.getName().toString();
        Bukkit.getLogger().info(playerName);
        OfflinePlayer offlinePlayer = (OfflinePlayer) player;
        World currentWorld = player.getWorld();
        if (GrassBlockSMPPlugin.fatal) {
            currentWorld.dropItemNaturally(player.getLocation(), LifeItemsManager.life);
            int lives = newLifeConfig.getInt(player.getUniqueId().toString() + "-lives");
            if (lives >= 1) {
                int affectedLives = 0;
                lives = 0;
                lifeBannedPlayers.add(offlinePlayer);
                Bukkit.getBanList(BanList.Type.NAME).addBan(playerName, "§4§lYou Have Lost All Your Lives.\n§r§fYou can be unbanned by a player using the Beacon of Revival.", null, "console");
                newLifeConfig.set(player.getUniqueId().toString() + "-lives", 0);
                newLifeConfig.set("lifeBannedPlayers", lifeBannedPlayers);
            } else {
                int affectedLives = lives - 1;
                newLifeConfig.set(player.getUniqueId().toString() + "-lives", affectedLives);
                try {
                    newLifeConfig.save(newLifeConfigFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                lives = affectedLives;
                try {
                    newLifeConfig.save(newLifeConfigFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    newLifeConfig.load(newLifeConfigFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InvalidConfigurationException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event, FileConfiguration lifeConfig, File lifeConfigFile) {
        Player player = event.getPlayer();
        if (!(player.hasPlayedBefore())) {
            String uniqueId = player.getUniqueId().toString();
            lifeConfig.addDefault(uniqueId + "-lives", 7);
            try {
                lifeConfig.save(lifeConfigFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (GrassBlockSMPPlugin.fatal == true) {
                player.sendTitle(null, "§o§cDeath is Fatal. Lives: §b" + lifeConfig.getString(player.getUniqueId().toString() + "-lives").toString());
            } else if (GrassBlockSMPPlugin.fatal == false) {
                player.sendTitle(null, "§o§aDeath is Not Fatal. §cLives: §b" + lifeConfig.getString(player.getUniqueId().toString() + "-lives").toString());
            }
        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event, FileConfiguration lifeConfig, File lifeConfigFile) {
        Player player = event.getPlayer();
        String uniqueId = player.getUniqueId().toString();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (player.getInventory().getItemInMainHand().getItemMeta().equals(LifeItemsManager.life.getItemMeta())) {
                int lives = lifeConfig.getInt(uniqueId + "-lives");
                lifeConfig.set(uniqueId + "-lives", lives + 1);
                player.getInventory().setItemInMainHand(null);
                try {
                    lifeConfig.save(lifeConfigFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (player.getInventory().getItemInMainHand().getItemMeta().equals(LifeItemsManager.life.getItemMeta())) {
                    int lives = lifeConfig.getInt(uniqueId + "-lives");
                    lifeConfig.set(uniqueId + "-lives", lives + 1);
                    player.getInventory().setItemInMainHand(null);
                    try {
                        lifeConfig.save(lifeConfigFile);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) {return; }
        if (event.getClickedInventory().getLocation() == null) {
            if (event.getClickedInventory().getHolder() instanceof UnbanScreen) {
                event.setCancelled(true);
                Player player = (Player) event.getWhoClicked();
                if (event.getCurrentItem() == null) {
                    return;
                } else if (event.getCurrentItem().equals(Material.GRAY_STAINED_GLASS_PANE)) {
                    return;
                } else if (event.getCurrentItem().equals(Material.BARRIER)) {
                    player.closeInventory();
                } else if (event.getCurrentItem().equals(Material.OAK_SIGN)) {

                }
            }
        } else {
            return;
        }
    }

    @EventHandler
    public void onArmorEquip(ArmorEquipEvent event) {
        if (event.getNewArmorPiece().equals(Material.ELYTRA)) {
            event.setCancelled(true);
        }
    }
}
