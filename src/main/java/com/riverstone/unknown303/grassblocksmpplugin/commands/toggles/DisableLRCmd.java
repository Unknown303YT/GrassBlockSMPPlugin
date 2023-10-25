//package com.riverstone.unknown303.grassblocksmpplugin.commands.toggles;
//
//import com.riverstone.unknown303.grassblocksmpplugin.GrassBlockSMPPlugin;
//import com.riverstone.unknown303.grassblocksmpplugin.items.LeadersDefenceManager;
//import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
//import org.bukkit.command.CommandSender;
//import com.riverstone.unknown303.grassblocksmpplugin.Variables;
//import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.entity.Player;
//
//public class DisableLRCmd implements CommandExecutor {
//    private GrassBlockSMPPlugin plugin;
//    public DisableLRCmd(GrassBlockSMPPlugin pl) {
//        plugin = pl;
//    }
//    @Override
//    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//        FileConfiguration config = plugin.getConfig();
//        if (cmd.getName().equals("disableLD")) {
//            if (Variables.leadersDefenceEnabled == 1) {
//                Variables.leadersDefenceEnabled = 0;
//                config.set("leadersdefence", "disabled");
//                plugin.saveConfig();
//                for (Player player : Bukkit.getOnlinePlayers()) {
//                    player.getInventory().remove(LeadersDefenceManager.leadersHat);
//                    player.getInventory().remove(LeadersDefenceManager.leadersShirt);
//                    player.getInventory().remove(LeadersDefenceManager.leadersPants);
//                    player.getInventory().remove(LeadersDefenceManager.leadersShoes);
//                }
//                sender.sendMessage(Variables.messsagePrefix + "Leader's Defence Disabled.");
//                return true;
//            } else {
//                if (Variables.leadersDefenceEnabled == 2) {
//                    Variables.leadersDefenceEnabled = 0;
//                    sender.sendMessage(Variables.messsagePrefix + ChatColor.GRAY + "Leader's Defence Disabled.");
//                    return true;
//                } else {
//                    if (Variables.leadersDefenceEnabled == 0) {
//                        sender.sendMessage(Variables.messsagePrefix + ChatColor.GRAY + "Leader's Defence is already Disabled.");
//                        return true;
//                    } else {
//                        sender.sendMessage(Variables.messsagePrefix +  ChatColor.DARK_RED + "Error: " + ChatColor.WHITE + "Leader's Defence can only be Enabled, Disabled or No-Clear. Please alert the plugin maker of the following information:\n" + ChatColor.GRAY + "Error: leadersDefenceEnabled == !0,1,2");
//                        return true;
//                    }
//                }
//            }
//        }
//        return true;
//    }
//}