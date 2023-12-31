package com.riverstone.unknown303.grassblocksmpplugin.guis;

import com.riverstone.unknown303.grassblocksmpplugin.events.LifeEvents;
import com.riverstone.unknown303.grassblocksmpplugin.items.LifeItemsManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class UnbanScreen implements InventoryHolder, Listener {
    private static Inventory gui = Bukkit.createInventory(new UnbanScreen(), 27, "Unban A Player");

    public static void init() {
        int lbpLSize = LifeEvents.lifeBannedPlayers.size();
        List<OfflinePlayer> playersNeedHead = new ArrayList<>();
        playersNeedHead.addAll(LifeEvents.lifeBannedPlayers);
        if (lbpLSize < 35) {
            for (int i = 1; i < lbpLSize; i++) {
                ItemStack skull = createHead(playersNeedHead.get(1), playersNeedHead);
                gui.setItem(gui.firstEmpty(), skull);

            }
            gui.setItem(26, LifeItemsManager.cancelBarrier);
            for (int blankPanesNeeded = (26 - lbpLSize); blankPanesNeeded < 26; blankPanesNeeded++) {
                gui.setItem(blankPanesNeeded, LifeItemsManager.blankPane);
            }
        }
    }

    @Override
    public Inventory getInventory() {
        return gui;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getClickedBlock().equals(LifeItemsManager.reviveBeacon)) {
                player.closeInventory();
                UnbanScreen unbanGUI = new UnbanScreen();
                player.openInventory(unbanGUI.getInventory());
            }
        }
    }

    private static ItemStack createHead(OfflinePlayer skullOwner, List<OfflinePlayer> playersNeedHead) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwningPlayer(skullOwner);
        skullMeta.setDisplayName("§o§f" + skullOwner.getName());
        List<String> lore = new ArrayList<>();
        lore.add("§o§fClick to Unban " + skullOwner.getName());
        skullMeta.setLore(lore);
        playersNeedHead.remove(skullOwner);
        return skull;
    }
}
