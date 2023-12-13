package com.riverstone.unknown303.grassblocksmpplugin.commands.lifecmds;

import com.riverstone.unknown303.grassblocksmpplugin.GrassBlockSMPPlugin;
import com.riverstone.unknown303.grassblocksmpplugin.items.LifeItemsManager;
import com.sun.jdi.IntegerType;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class WithdrawCommand implements CommandExecutor {
    FileConfiguration newLifeConfig;
    File newLifeConfigFile;


    public WithdrawCommand(FileConfiguration lifeConfig, File lifeConfigFile) {
        newLifeConfig = lifeConfig;
        newLifeConfigFile = lifeConfigFile;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Only Players Can Use This Command!");
                return true;
            }
            assert sender instanceof Player;
                Player player = (Player) sender;
                if (args.length == 1) {
                    int withdrawnLives = Integer.parseInt(args[0]);
                    int newLives = newLifeConfig.getInt(player.getUniqueId().toString() + "-lives");
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
