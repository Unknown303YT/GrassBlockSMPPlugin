package com.riverstone.unknown303.grassblocksmpplugin.commands.ticmds;

import com.riverstone.unknown303.grassblocksmpplugin.references.Variables;
import com.riverstone.unknown303.grassblocksmpplugin.items.TeamItemsManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LDHCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //Check if a player is running the command
        if (!(sender instanceof Player)) {
            sender.sendMessage(Variables.pmPrefix + "Only Players can use this command!");
            return true;
        }
        //Get Leader's Helmet
        Player player = (Player) sender;
        if (cmd.getName().equals("getLDHelm")) {
            if (Variables.teamItemsStatus == "enabled") {
                player.getInventory().addItem(TeamItemsManager.leadersHat);
            } else {
                sender.sendMessage(Variables.pmPrefix + "Team Items are Disabled.");
            }
        }
        return true;
    }
}