//package com.riverstone.unknown303.grassblocksmpplugin.commands.toggles;
//
//import com.riverstone.unknown303.grassblocksmpplugin.GrassBlockSMPPlugin;
//import com.riverstone.unknown303.grassblocksmpplugin.multiclassreferencefiles.Variables;
//import org.bukkit.ChatColor;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
//import org.bukkit.command.CommandSender;
//import org.bukkit.configuration.file.FileConfiguration;
//
//public class NoClearLRCmd implements CommandExecutor {
//    private GrassBlockSMPPlugin plugin;
//    public NoClearLRCmd(GrassBlockSMPPlugin pl) {
//        plugin = pl;
//    }
//    @Override
//    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//        FileConfiguration config = plugin.getConfig();
//        if (cmd.getName().equals("ncLD")) {
//            if (Variables.leadersDefenceEnabled == 0) {
//                Variables.leadersDefenceEnabled = 2;
//                config.set("leadersdefence", "no-clear");
//                plugin.saveConfig();
//                sender.sendMessage(Variables.messsagePrefix + ChatColor.GRAY + "Leader's Defence Disabled with No Clear.");
//                return true;
//            } else {
//                if (Variables.leadersDefenceEnabled == 1) {
//                    Variables.leadersDefenceEnabled = 2;
//                    sender.sendMessage(Variables.messsagePrefix + ChatColor.GRAY + "Leader's Defence Disabled with No Clear.");
//                    return true;
//                } else {
//                    if (Variables.leadersDefenceEnabled == 2) {
//                        sender.sendMessage(Variables.messsagePrefix + ChatColor.GRAY + "Leader's Defence is already Disabled with No Clear.");
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
