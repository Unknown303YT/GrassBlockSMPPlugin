package com.riverstone.unknown303.grassblocksmpplugin.commands.ticmds;

import com.riverstone.unknown303.grassblocksmpplugin.multiclassreferencefiles.Variables;
import com.riverstone.unknown303.grassblocksmpplugin.items.TeamItemsManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LDCCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //Check if a player is running the command
        if (!(sender instanceof Player)) {
            sender.sendMessage(Variables.pmPrefix + "Only Players can use this command!");
            return true;
        }
        //Get Leader's Chestplate
        Player player = (Player) sender;
        if (cmd.getName().equals("getLDChestplate")) {
            if (Variables.teamItemsStatus == "enabled") {
                player.getInventory().addItem(TeamItemsManager.leadersShirt);
            } else {
                sender.sendMessage(Variables.pmPrefix + "Team Items are Disabled.");
            }
        }
        return true;
    }
}