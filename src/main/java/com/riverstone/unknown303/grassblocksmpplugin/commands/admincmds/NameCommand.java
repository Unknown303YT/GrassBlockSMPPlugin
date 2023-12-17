package com.riverstone.unknown303.grassblocksmpplugin.commands.admincmds;

import com.riverstone.unknown303.grassblocksmpplugin.references.Variables;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length != 2) {
            sender.sendMessage(Variables.pmPrefix + "Error: Expected 2 Arguments, got " + args.length);
            return true;
        }
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getName() == args[0]) {
                player.setDisplayName(args[1] + " " + player.getName());
            }
        }
        return true;
    }
}
