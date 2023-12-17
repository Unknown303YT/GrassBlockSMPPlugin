package com.riverstone.unknown303.grassblocksmpplugin.commands.lifecmds;

import com.riverstone.unknown303.grassblocksmpplugin.GrassBlockSMPPlugin;
import com.riverstone.unknown303.grassblocksmpplugin.items.LifeItemsManager;
import com.riverstone.unknown303.grassblocksmpplugin.references.Variables;
import com.sun.jdi.IntegerType;
import com.sun.jdi.IntegerValue;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.io.File;
import java.io.IOException;

public class WithdrawCommand implements CommandExecutor, Listener {
    FileConfiguration newLifeConfig;
    File newLifeConfigFile;
    public boolean confirmable;
    GrassBlockSMPPlugin plugin;


    public WithdrawCommand(FileConfiguration lifeConfig, File lifeConfigFile, GrassBlockSMPPlugin pl) {
        newLifeConfig = lifeConfig;
        newLifeConfigFile = lifeConfigFile;
        plugin = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Only Players Can Use This Command!");
                return true;
            }
        Player player = (Player) sender;
                if (args.length == 1) {
                    int withdrawnLives = Integer.parseInt(args[0]);
                    if (confirmable = true) {
                        if (withdrawnLives == newLifeConfig.getInt(player.getUniqueId().toString() + "-lives")) {
                            newLifeConfig.set(player.getUniqueId().toString() + "-lives", 0);
                            Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), "§4§lYou Have Lost All Your Lives.\n§r§fYou can be unbanned by a player using the Beacon of Revival.", null, "console");
                            player.kickPlayer("§4§lYou Have Lost All Your Lives.\n§r§fYou can be unbanned by a player using the Beacon of Revival.");
                            return true;
                        }
                    }
                    int newLives = newLifeConfig.getInt(player.getUniqueId().toString() + "-lives");
                    if (withdrawnLives > newLifeConfig.getInt(player.getUniqueId().toString() + "-lives")) {
                        sender.sendMessage(Variables.pmPrefix + ChatColor.RED + "Error: Attempted to Withdraw More Lives than Player Had.");
                        return true;
                    }
                    if (withdrawnLives == newLifeConfig.getInt(player.getUniqueId().toString() + "-lives")) {
                        sender.sendMessage(Variables.pmPrefix + "Your entered value is equal to your number of lives. This will ban you.\n" +
                                "Type again before 30 seconds is up to confirm.");
                        confirmable = true;
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                confirmable = false;
                            }
                        }.runTaskLater(this.plugin, 600);
                    }
                    for (int i = 0; i < withdrawnLives; i++) {
                        newLifeConfig.set(player.getUniqueId().toString() + "-lives", newLives - 1);
                        player.getInventory().addItem(LifeItemsManager.life);
                    }
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
                } else {
                    sender.sendMessage(ChatColor.RED + "Error: Expected 1 argument, got " + args.length + " " + ChatColor.WHITE + "Usage: /withdraw <lives>");
                }
        return true;
    }
}
