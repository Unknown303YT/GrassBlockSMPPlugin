package com.riverstone.unknown303.grassblocksmpplugin.commands.ticmds;

import com.riverstone.unknown303.grassblocksmpplugin.multiclassreferencefiles.Variables;
import com.riverstone.unknown303.grassblocksmpplugin.items.TeamItemsManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LDSCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //Check if a player is running the command
        if (!(sender instanceof Player)) {
            sender.sendMessage(Variables.pmPrefix + "Only Players can use this command!");
        }
        assert sender instanceof Player;
        //Get Leader's Refuge
        Player player = (Player) sender;
        if (cmd.getName().equals("getLDSet")) {
            if (Variables.teamItemsStatus == "enabled") {
                player.getInventory().addItem(TeamItemsManager.leadersHat);
                player.getInventory().addItem(TeamItemsManager.leadersShirt);
                player.getInventory().addItem(TeamItemsManager.leadersPants);
                player.getInventory().addItem(TeamItemsManager.leadersShoes);
            } else {
                sender.sendMessage(Variables.pmPrefix + "Team Items are Disabled.");
            }
        }
        return true;
    }
}