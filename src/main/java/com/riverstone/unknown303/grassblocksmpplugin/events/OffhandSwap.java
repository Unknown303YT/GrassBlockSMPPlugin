//package com.riverstone.unknown303.grassblocksmpplugin.events;
//
//import com.riverstone.unknown303.grassblocksmpplugin.items.AdminItemsManager;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.inventory.InventoryClickEvent;
//import org.bukkit.event.player.PlayerSwapHandItemsEvent;
//
//public class OffhandSwap implements Listener {
//    @EventHandler
//    public void onHandSwap(PlayerSwapHandItemsEvent event) {
//        Player player = event.getPlayer();
//        try {
//            wait(250);
//            if (player.getInventory().getItemInOffHand().getItemMeta().equals(AdminItemsManager.flyFeather.getItemMeta())) {
//                player.setAllowFlight(true);
//                player.setFlying(true);
//            } else {
//                player.setFlying(true);
//                player.setAllowFlight(true);
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @EventHandler
//    public void onClick(InventoryClickEvent event) {
//        try {
//            wait(250);
//            Player player = (Player) event.getWhoClicked();
//            if (player.getInventory().getItemInOffHand().getItemMeta().equals(AdminItemsManager.flyFeather.getItemMeta())) {
//                player.setAllowFlight(true);
//                player.setFlying(true);
//            } else {
//                player.setFlying(true);
//                player.setAllowFlight(true);
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
