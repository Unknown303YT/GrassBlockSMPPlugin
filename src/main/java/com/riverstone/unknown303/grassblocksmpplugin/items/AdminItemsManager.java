package com.riverstone.unknown303.grassblocksmpplugin.items;

import com.riverstone.unknown303.grassblocksmpplugin.Variables;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AdminItemsManager {
    public static ItemStack flyFeather;
    public static ItemStack kickSword;

    public static void init() {
        createFly();
        createKick();
    }

    private static void createFly() {
        Bukkit.getLogger().info(Variables.logPrefix + "Creating FlyHack Feather... ");
        ItemStack item = new ItemStack(Material.FEATHER, 1);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying FlyHack Feather Custom Properties... ");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§l§4FlyHack Feather");
        List<String> lore = new ArrayList<>();
        lore.add("§o§fGrants Holder the Gift of Flight");
        meta.setLore(lore);
        meta.isUnbreakable();
        meta.setUnbreakable(true);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying FlyHack Feather Enchantments... ");
        meta.addEnchant(Enchantment.DURABILITY, 255, false);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(meta);
        flyFeather = item;
        Bukkit.getLogger().info(Variables.logPrefix + "FlyHack Feather Created");
    }

    private static void createKick() {
        Bukkit.getLogger().info(Variables.logPrefix + "Creating Kick Sword... ");
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Kick Sword Custom Properties... ");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§l§Kick Sword");
        List<String> lore = new ArrayList<>();
        lore.add("§o§fIf You are Hit With This,");
        lore.add("§o§fYou Get Kicked from the Server");
        meta.setLore(lore);
        meta.isUnbreakable();
        meta.setUnbreakable(true);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Kick Sword Enchantments... ");
        meta.addEnchant(Enchantment.DURABILITY, 255, false);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(meta);
        kickSword = item;
        Bukkit.getLogger().info(Variables.logPrefix + "Kick Sword Created");
    }
}
