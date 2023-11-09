package com.riverstone.unknown303.grassblocksmpplugin.events;

import com.riverstone.unknown303.grassblocksmpplugin.items.OnceoffItemsManager;
import com.riverstone.unknown303.grassblocksmpplugin.items.TeamItemsManager;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class ItemEvents implements Listener {

    // Loner's Shield

    Player playerEntity;
    Inventory playerEntityInventory;

    @EventHandler
    public void onInvChange(InventoryMoveItemEvent event) {
        lShieldInvChecks(event);
    }

    private void lShieldInvChecks(InventoryMoveItemEvent event) {
        Inventory eventInv = event.getSource();
        List<HumanEntity> viewers = event.getSource().getViewers();
        for (HumanEntity entity : viewers) {
            playerEntity = (Player) entity;
            playerEntityInventory = (Inventory) playerEntity.getInventory();
        }
        if (eventInv.equals(playerEntityInventory)) {
            if (event.getItem().equals(playerEntity.getInventory().getItemInOffHand())) {
                if (event.getItem().getItemMeta().equals(TeamItemsManager.lonersShield.getItemMeta())) {
                    playerEntity.addPotionEffect(PotionEffectType.SATURATION.createEffect(300, 3));
                    try {
                        wait(270000);
                        lShieldInvChecks(event);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } else {
            playerEntity.removePotionEffect(PotionEffectType.SATURATION);
        }
    }

    @EventHandler
    public void onArmorEquip(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.getInventory().getItemInOffHand().getItemMeta().equals(TeamItemsManager.lonersShield.getItemMeta())) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 9999, 5));
            } else {
                player.removePotionEffect(PotionEffectType.SATURATION);
            }
        } else {
            if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                if (player.getInventory().getItemInOffHand().getItemMeta().equals(TeamItemsManager.lonersShield.getItemMeta())) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 9999, 5));
                } else {
                    player.removePotionEffect(PotionEffectType.SATURATION);
                }
            }
        }
    }


    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.getInventory().getItemInMainHand().equals(OnceoffItemsManager.tntWand)) {
                player.getWorld().createExplosion(player.getTargetBlock(null, 100).getLocation(), 5);
                OnceoffItemsManager.tntWandDurability = OnceoffItemsManager.tntWandDurability - 1;
                List<String> lore = new ArrayList<>();
                lore.add("§o§fRight Click to Use");
                lore.add("§o§6Note: Only Has 5 Uses!");
                lore.add("§o§fUses: " + OnceoffItemsManager.tntWandDurability + "/5");
                OnceoffItemsManager.tntWand.getItemMeta().setLore(lore);
            }
        }
    }
}
