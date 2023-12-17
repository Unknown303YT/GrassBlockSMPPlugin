package com.riverstone.unknown303.grassblocksmpplugin;

import com.jeff_media.armorequipevent.ArmorEquipEvent;
import com.riverstone.unknown303.grassblocksmpplugin.commands.admincmds.toggles.ToggleTI;
import com.riverstone.unknown303.grassblocksmpplugin.commands.lifecmds.WithdrawCommand;
import com.riverstone.unknown303.grassblocksmpplugin.commands.ticmds.*;
import com.riverstone.unknown303.grassblocksmpplugin.events.ItemEvents;
import com.riverstone.unknown303.grassblocksmpplugin.events.LifeEvents;
import com.riverstone.unknown303.grassblocksmpplugin.events.MiscEvents;
import com.riverstone.unknown303.grassblocksmpplugin.guis.UnbanScreen;
import com.riverstone.unknown303.grassblocksmpplugin.items.OnceoffItemsManager;
import com.riverstone.unknown303.grassblocksmpplugin.references.Variables;
import com.riverstone.unknown303.grassblocksmpplugin.items.AdminItemsManager;
import com.riverstone.unknown303.grassblocksmpplugin.items.TeamItemsManager;
import com.riverstone.unknown303.grassblocksmpplugin.items.LifeItemsManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public final class GrassBlockSMPPlugin extends JavaPlugin {
   public static boolean fatal;
   public static GrassBlockSMPPlugin thisPlugin;
    @Override
    public void onEnable() {

        thisPlugin = this;

        File configFile = new File(this.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        File lifeConfigFile = new File(this.getDataFolder(), "lifeConfig.yml");
        FileConfiguration lifeConfig = YamlConfiguration.loadConfiguration(lifeConfigFile);

        ArmorEquipEvent.registerListener(this);


        try {
            lifeConfig.save(lifeConfigFile);
            config.save(configFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        Bukkit.getLogger().info(Variables.logPrefix + "Starting GrassBlockSMP Custom Plugin...");
        Bukkit.getLogger().info(Variables.logPrefix + "Thank you to Unknown_303YT for making this for the server.");

        Bukkit.getLogger().info(Variables.logPrefix + "Setting Up Main Config File... ");
        config.addDefault("teamItemsStatus", "enabled");
        config.addDefault("config-version", 2);
        try {
            config.save(configFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Variables.teamItemsStatus = config.getString("teamItemsStatus");
        Bukkit.getLogger().info(Variables.logPrefix + "Main Config File Set Up");

        Bukkit.getLogger().info(Variables.logPrefix + "Enabling Team Items... ");
        TeamItemsManager.init();
        Bukkit.getLogger().info(Variables.logPrefix + "Team Items Enabled");

        Bukkit.getLogger().info(Variables.logPrefix + "Enabling Life Items... ");
        LifeItemsManager.init();
        Bukkit.getLogger().info(Variables.logPrefix + "Life Items Enabled");

        Bukkit.getLogger().info(Variables.logPrefix + "Enabling Admin Items... ");
        AdminItemsManager.init();
        Bukkit.getLogger().info(Variables.logPrefix + "Admin Items Enabled");

        Bukkit.getLogger().info(Variables.logPrefix + "Enabling Once-Off Items");
        OnceoffItemsManager.init();
        Bukkit.getLogger().info(Variables.logPrefix + "Once-Off Items Enabled");

        Bukkit.getLogger().info(Variables.logPrefix + "Enabling Unban GUI... ");
        UnbanScreen.init();
        Bukkit.getLogger().info(Variables.logPrefix + "Unban GUI Enabled");

        Bukkit.getLogger().info(Variables.logPrefix + "Enabling Event Classes... ");
        Bukkit.getServer().getPluginManager().registerEvents(new MiscEvents(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new LifeEvents(lifeConfig, lifeConfigFile), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ItemEvents(), this);
        Bukkit.getLogger().info(Variables.logPrefix + "Event Classes Enabled");

        Bukkit.getLogger().info(Variables.logPrefix + "Enabling Commands... ");
        Objects.requireNonNull(getCommand("withdraw")).setExecutor(new WithdrawCommand(lifeConfig, lifeConfigFile, this));
        Objects.requireNonNull(getCommand("getLDHelm")).setExecutor(new LDHCmd());
        Objects.requireNonNull(getCommand("getLDBoots")).setExecutor(new LDBCmd());
        Objects.requireNonNull(getCommand("getLDChestplate")).setExecutor(new LDCCmd());
        Objects.requireNonNull(getCommand("getLDLeggings")).setExecutor(new LDLCmd());
        Objects.requireNonNull(getCommand("getLDSet")).setExecutor(new LDSCmd());
        Objects.requireNonNull(getCommand("getLShield")).setExecutor(new LSCmd());
        Objects.requireNonNull(getCommand("toggle")).setExecutor(new ToggleTI());
        Bukkit.getLogger().info(Variables.logPrefix + "Commands Enabled");

        LifeEvents.lifeBannedPlayers = (List<OfflinePlayer>) lifeConfig.get("lifeBannedPlayers");
        if (LifeEvents.lifeBannedPlayers == null) {
            Bukkit.getLogger().info(Variables.logPrefix + "Error: lifeBannedPlayers == null");
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        fatal = true;
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                fatal = false;
                            }
                        }.runTaskLater(thisPlugin, 72000);
                    }
                }.runTaskLater(thisPlugin, 216000);
            }
        }.runTaskTimer(this, 1L, 20L);

        new BukkitRunnable() {
            public void run() {

            }
        }.runTaskAsynchronously(this);  {

        }

    }


    @Override
    public void onDisable() {
        Bukkit.getLogger().info(Variables.logPrefix + "Shutting Down GrassBlockSMP Custom Plugin...");
    }

    public void checkTime() {
        // CHECK WHEN TO SHUT DOWN SERVER
        new BukkitRunnable() {

            public void run() {
                LocalDateTime now = LocalDateTime.now();
                int hour = now.getHour();
                int minute = now.getMinute();
                int second = now.getSecond();

                //Not hour 20? Then we don't need to run the rest of the code
                if(hour != 20) {
                    if (hour != 21) {
                        return;
                    }
                }

                //At this point we no longer need this runnable
                //We start a new runnable for the final minute countdown and shut down this one
                if(minute == 59 && second == 30) {
                    sendCountdownMessages();
                    this.cancel();
                    return;
                }

                //More compact way for the big counter
                //You might want to use a switch case here instead if it's hard to read/understand
                Integer countdown = minute % 5 == 0 && minute >= 45 && minute <= 55 ? 60 - minute : null;

                if(countdown != null)
                    sendMessageToPlayers("Server Shutting Down in " + countdown + " Minutes!");
            }

            //Task runs every 1200 ticks = 1 minute
        }.runTaskTimer(this, 0, 1200);
    }

    //Using another method to send the message
    //We do this because it keeps the code cleaner since we don't use extra lines of codes
    private void sendMessageToPlayers(String message) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(ChatColor.YELLOW + message);
        }
    }

    private void sendCountdownMessages(){
        new BukkitRunnable() {

            int i = 30;
            public void run() {
                if(i < 0) {
                    this.cancel();
                    Bukkit.getServer().shutdown();
                    return;
                }

                if((i == 30 || i == 15 || i <= 10))
                    sendMessageToPlayers("Server Shutting Down in " + i-- + " Seconds!");
            }

        }.runTaskTimer(this, 0, 20);
    }

}

