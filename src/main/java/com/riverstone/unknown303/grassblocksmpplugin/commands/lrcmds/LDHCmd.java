package com.riverstone.unknown303.grassblocksmpplugin.commands.lrcmds;

import com.riverstone.unknown303.grassblocksmpplugin.multiclassreferencefiles.Variables;
import com.riverstone.unknown303.grassblocksmpplugin.items.LeadersDefenceManager;
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
        if (cmd.getName().equalsIgnoreCase("getLDHelm")) {
            //if (Variables.leadersRefugeEnabled == 0) {
            //sender.sendMessage(Variables.messsagePrefix + ChatColor.GRAY + "Leader's Refuge is Disabled.");
            //return true;
            //} else {
            //if (Variables.leadersRefugeEnabled == 2) {
            //sender.sendMessage(Variables.messsagePrefix + ChatColor.GRAY + "Leader's Refuge is Disabled.");
            //return true;
            //} else {
            //if (Variables.leadersRefugeEnabled == 1) {
            player.getInventory().addItem(LeadersDefenceManager.leadersHat);
            return true;
            //} else {
            //sender.sendMessage(Variables.messsagePrefix + ChatColor.GRAY + "§l§4Error: §fLeader's Refuge can only be Enabled, Disabled or No-Clear. Please alert the plugin maker of the following information:\n§7Error: leadersRefugeEnabled == !0,1,2");
            //return true;
            //}
            //}
            //}
        }
        return true;
    }
}