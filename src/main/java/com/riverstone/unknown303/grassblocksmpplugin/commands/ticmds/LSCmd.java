package com.riverstone.unknown303.grassblocksmpplugin.commands.ticmds;

import com.riverstone.unknown303.grassblocksmpplugin.items.TeamItemsManager;
import com.riverstone.unknown303.grassblocksmpplugin.references.Variables;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LSCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equals("getLShield")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(Variables.pmPrefix + "Only Players Can Use This Command");
            }
            assert sender instanceof Player;
            Player player = (Player) sender;
            if (Variables.teamItemsStatus == "enabled") {
                player.getInventory().addItem(TeamItemsManager.lonersShield);
            } else {
                sender.sendMessage(Variables.pmPrefix + "Team Items Are Disabled!");
            }
        }
        return true;
    }
}
