package com.riverstone.unknown303.grassblocksmpplugin.events;

import com.jeff_media.armorequipevent.ArmorEquipEvent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MiscEvents implements Listener {
    @EventHandler
    public void onArmorEquip(ArmorEquipEvent event) {
        if (event.getNewArmorPiece().equals(Material.ELYTRA)) {
            event.setCancelled(true);
        }
    }
}
