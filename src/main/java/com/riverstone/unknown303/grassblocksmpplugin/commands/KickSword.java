//package com.riverstone.unknown303.grassblocksmpplugin.commands;
//
//import com.riverstone.unknown303.grassblocksmpplugin.items.AdminItemsManager;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
//import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;
//
//public class KickSword implements CommandExecutor {
//    @Override
//    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//        if (cmd.getName().equals("getKickSword")) {
//            Player player = (Player) sender;
//            player.getInventory().addItem(AdminItemsManager.kickSword);
//        }
//        return true;
//    }
//}
