//package com.riverstone.unknown303.grassblocksmpplugin.events;
//
//import org.bukkit.Bukkit;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.player.AsyncPlayerChatEvent;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Supplier;
//
//public class SpamKickEvent implements Listener {
//    @EventHandler
//    public static void AsyncChatEvent(AsyncPlayerChatEvent playerChat) {
//        Player player = playerChat.getPlayer();
//        String msg = playerChat.getMessage();
//
//        List<String> msgs = new ArrayList<>();
//        msgs.add(msg);
//        for(String string : msgs) {
//            player.sendMessage(string);//This will send the player all the strings in the ArrayList
//        }
//
//
//
//
//
//
//    }
//}
