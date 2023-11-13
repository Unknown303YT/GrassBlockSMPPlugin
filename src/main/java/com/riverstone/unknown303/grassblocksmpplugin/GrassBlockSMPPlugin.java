package com.riverstone.unknown303.grassblocksmpplugin;

import com.riverstone.unknown303.grassblocksmpplugin.commands.admincmds.toggles.ToggleTI;
import com.riverstone.unknown303.grassblocksmpplugin.commands.lifecmds.WithdrawCommand;
import com.riverstone.unknown303.grassblocksmpplugin.commands.ticmds.*;
import com.riverstone.unknown303.grassblocksmpplugin.events.ItemEvents;
import com.riverstone.unknown303.grassblocksmpplugin.events.LifeEvents;
import com.riverstone.unknown303.grassblocksmpplugin.guis.UnbanScreen;
import com.riverstone.unknown303.grassblocksmpplugin.items.OnceoffItemsManager;
import com.riverstone.unknown303.grassblocksmpplugin.multiclassreferencefiles.Variables;
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

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public final class GrassBlockSMPPlugin extends JavaPlugin {
   public static boolean fatal;
    @Override
    public void onEnable() {

        File configFile = new File(this.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        File lifeConfigFile = new File(this.getDataFolder(), "lifeConfig.yml");
        FileConfiguration lifeConfig = YamlConfiguration.loadConfiguration(lifeConfigFile);


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
        Bukkit.getServer().getPluginManager().registerEvents(new LifeEvents(lifeConfig, lifeConfigFile), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ItemEvents(), this);
        Bukkit.getLogger().info(Variables.logPrefix + "Event Classes Enabled");

        Bukkit.getLogger().info(Variables.logPrefix + "Enabling Command Classes... ");
        Objects.requireNonNull(getCommand("withdraw")).setExecutor(new WithdrawCommand(lifeConfig, lifeConfigFile));
        Objects.requireNonNull(getCommand("getLDHelm")).setExecutor(new LDHCmd());
        Objects.requireNonNull(getCommand("getLDBoots")).setExecutor(new LDBCmd());
        Objects.requireNonNull(getCommand("getLDChestplate")).setExecutor(new LDCCmd());
        Objects.requireNonNull(getCommand("getLDLeggings")).setExecutor(new LDLCmd());
        Objects.requireNonNull(getCommand("getLDSet")).setExecutor(new LDSCmd());
        Objects.requireNonNull(getCommand("getLShield")).setExecutor(new LSCmd());
        Objects.requireNonNull(getCommand("toggle")).setExecutor(new ToggleTI());
        Bukkit.getLogger().info(Variables.logPrefix + "Command Classes Enabled");

        LifeEvents.lifeBannedPlayers = (List<OfflinePlayer>) lifeConfig.get("lifeBannedPlayers");
        if (LifeEvents.lifeBannedPlayers == null) {
            Bukkit.getLogger().info(Variables.logPrefix + "Error: lifeBannedPlayers == null");
        }

        Bukkit.getScheduler().runTaskLater(this, loopFatal(), 1200);

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info(Variables.logPrefix + "Shutting Down GrassBlockSMP Custom Plugin...");

    }

    public Runnable loopFatal() {
        while (true) {
            fatal = false;
            Bukkit.getScheduler().runTaskLater(this, fatalTrue(), 216000);
            Bukkit.getScheduler().runTaskLater(this, fatalFalse(), 72000);
        }
    }

    public Runnable fatalFalse() {
        fatal = false;
        return null;
    }

    public Runnable fatalTrue() {
        fatal = true;
        return null;
    }

    public void checkTime() {
        // CHECK WHEN TO SHUT DOWN SERVER
        int hour = LocalDateTime.now().getHour();
        int minute = LocalDateTime.now().getMinute();
        while (true) {
            if (hour == 21) {
                if (minute == 0) {
                    Bukkit.getServer().shutdown();
                }
            } else {
                int second = LocalDateTime.now().getSecond();
                if (hour == 20) {
                    if (minute == 45) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 15 Minutes!");
                        }
                    } else {
                        if (minute == 50) {
                            for (Player player : Bukkit.getOnlinePlayers()) {
                                player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 10 Minutes!");
                            }
                        } else {
                            if (minute == 55) {
                                for (Player player : Bukkit.getOnlinePlayers()) {
                                    player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 5 Minutes!");
                                }
                            } else {
                                if (minute == 59) {
                                    if (second == 30) {
                                        for (Player player : Bukkit.getOnlinePlayers()) {
                                            player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 30 Seconds!");
                                        }
                                        try {
                                            Bukkit.getScheduler().wait(15000);
                                            for (Player player : Bukkit.getOnlinePlayers()) {
                                                player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 15 Seconds!");
                                            }
                                            Bukkit.getScheduler().wait(5000);
                                            for (Player player : Bukkit.getOnlinePlayers()) {
                                                player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 10 Seconds!");
                                            }
                                            // TEN SECOND COUNTDOWN
                                            Bukkit.getScheduler().wait(1000);
                                            for (Player player : Bukkit.getOnlinePlayers()) {
                                                player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 9 Seconds!");
                                            }
                                            Bukkit.getScheduler().wait(1000);
                                            for (Player player : Bukkit.getOnlinePlayers()) {
                                                player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 8 Seconds!");
                                            }
                                            Bukkit.getScheduler().wait(1000);
                                            for (Player player : Bukkit.getOnlinePlayers()) {
                                                player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 7 Seconds!");
                                            }
                                            Bukkit.getScheduler().wait(1000);
                                            for (Player player : Bukkit.getOnlinePlayers()) {
                                                player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 6 Seconds!");
                                            }
                                            Bukkit.getScheduler().wait(1000);
                                            for (Player player : Bukkit.getOnlinePlayers()) {
                                                player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 5 Seconds!");
                                            }
                                            Bukkit.getScheduler().wait(1000);
                                            for (Player player : Bukkit.getOnlinePlayers()) {
                                                player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 4 Seconds!");
                                            }
                                            Bukkit.getScheduler().wait(1000);
                                            for (Player player : Bukkit.getOnlinePlayers()) {
                                                player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 3 Seconds!");
                                            }
                                            Bukkit.getScheduler().wait(1000);
                                            for (Player player : Bukkit.getOnlinePlayers()) {
                                                player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 2 Seconds!");
                                            }
                                            Bukkit.getScheduler().wait(1000);
                                            for (Player player : Bukkit.getOnlinePlayers()) {
                                                player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 1 Seconds!");
                                            }
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                    } else {
                                        if (second == 45) {
                                            for (Player player : Bukkit.getOnlinePlayers()) {
                                                player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 15 Seconds!");
                                            }
                                        } else {
                                            if (second == 50) {
                                                for (Player player : Bukkit.getOnlinePlayers()) {
                                                    player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 10 Seconds!");
                                                }
                                            } else {
                                                //TEN SECOND CHECK
                                                if (second == 51) {
                                                    for (Player player : Bukkit.getOnlinePlayers()) {
                                                        player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 9 Seconds!");
                                                    }
                                                } else {
                                                    if (second == 52) {
                                                        for (Player player : Bukkit.getOnlinePlayers()) {
                                                            player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 8 Seconds!");
                                                        }
                                                    } else {
                                                        if (second == 53) {
                                                            for (Player player : Bukkit.getOnlinePlayers()) {
                                                                player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 7 Seconds!");
                                                            }
                                                        } else {
                                                            if (second == 54) {
                                                                for (Player player : Bukkit.getOnlinePlayers()) {
                                                                    player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 6 Seconds!");
                                                                }
                                                            } else {
                                                                if (second == 55) {
                                                                    for (Player player : Bukkit.getOnlinePlayers()) {
                                                                        player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 5 Seconds!");
                                                                    }
                                                                }
                                                                else {
                                                                    if (second == 56) {
                                                                        for (Player player : Bukkit.getOnlinePlayers()) {
                                                                            player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 4 Seconds!");
                                                                        }
                                                                    } else {
                                                                        if (second == 57) {
                                                                            for (Player player : Bukkit.getOnlinePlayers()) {
                                                                                player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 3 Seconds!");
                                                                            }
                                                                        } else {
                                                                            if (second == 58) {
                                                                                for (Player player : Bukkit.getOnlinePlayers()) {
                                                                                    player.sendMessage(ChatColor.YELLOW + "Server Shutting Down in 2 Seconds!");
                                                                                }
                                                                            } else {
                                                                                if (second == 59) {
                                                                                    for (Player player : Bukkit.getOnlinePlayers()) {
                                                                                        player.sendMessage(ChatColor.YELLOW + "Server Shutting Down.");
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            try {
                Bukkit.getScheduler().wait(60000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

