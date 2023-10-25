package com.riverstone.unknown303.grassblocksmpplugin.items;

import com.riverstone.unknown303.grassblocksmpplugin.multiclassreferencefiles.Variables;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class LifeItemsManager {
    public static ItemStack lifeFragment;
    public static ItemStack lifeShard;
    public static ItemStack life;
    public static ItemStack reviveBeacon;
    public static ItemStack cancelBarrier;
    public static ItemStack unbanSign;

    public static void init() {
        createFragment();
        createShard();
        createLife();
        createBeacon();
        createCancel();
        createUnban();
    }

    private static void createFragment() {
        Bukkit.getLogger().info(Variables.logPrefix + "Creating Life Fragment... ");
        ItemStack item = new ItemStack(Material.FIREWORK_STAR, 1);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Life Fragment Custom Properties... ");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§l§4Life Fragment");
        List<String> lore = new ArrayList<>();
        lore.add("§o§fOne of the Ingredients for Lives!");
        meta.setLore(lore);
        meta.isUnbreakable();
        meta.setUnbreakable(true);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Life Fragment Enchantments... ");
        meta.addEnchant(Enchantment.DURABILITY, 255, false);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(meta);
        lifeFragment = item;
        Bukkit.getLogger().info(Variables.logPrefix + "Life Fragment Created");
    }

    private static void createShard() {
        Bukkit.getLogger().info(Variables.logPrefix + "Creating Life Shard... ");
        ItemStack item = new ItemStack(Material.DIAMOND, 1);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Life Shard Custom Properties... ");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§l§4Life Shard");
        List<String> lore = new ArrayList<>();
        lore.add("§o§fOne of the Ingredients for Lives!");
        meta.setLore(lore);
        meta.isUnbreakable();
        meta.setUnbreakable(true);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Life Shard Enchantments... ");
        meta.addEnchant(Enchantment.DURABILITY, 255, false);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(meta);
        lifeShard = item;
        Bukkit.getLogger().info(Variables.logPrefix + "Life Shard Created");
    }

    private static void createLife() {
        Bukkit.getLogger().info(Variables.logPrefix + "Creating Life Item... ");
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Life Item Custom Properties... ");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§l§4Life");
        List<String> lore = new ArrayList<>();
        lore.add("§o§fUse One of These To Gain A Life!");
        meta.setLore(lore);
        meta.isUnbreakable();
        meta.setUnbreakable(true);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Life Item Enchantments... ");
        meta.addEnchant(Enchantment.DURABILITY, 255, false);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(meta);
        life = item;
        Bukkit.getLogger().info(Variables.logPrefix + "Life Item Created");
    }

    private static void createBeacon() {
        Bukkit.getLogger().info(Variables.logPrefix + "Creating Revive Beacon... ");
        ItemStack item = new ItemStack(Material.BEACON, 1);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Revive Beacon Custom Properties... ");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§l§6Revive Beacon");
        List<String> lore = new ArrayList<>();
        lore.add("§o§fUse One of These to Unban A Player!");
        meta.setLore(lore);
        meta.isUnbreakable();
        meta.setUnbreakable(true);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Revive Beacon Enchantments... ");
        meta.addEnchant(Enchantment.DURABILITY, 255, false);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(meta);
        reviveBeacon = item;
        Bukkit.getLogger().info(Variables.logPrefix + "Revive Beacon Created");
    }

    private static void createCancel() {
        Bukkit.getLogger().info(Variables.logPrefix + "Creating Cancel Barrier for GUI... ");
        ItemStack item = new ItemStack(Material.BARRIER, 1);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Cancel Barrier Custom Properties... ");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§l§4Cancel");
        List<String> lore = new ArrayList<>();
        lore.add("§o§fClick to Cancel the Unban and Close the GUI");
        meta.setLore(lore);
        meta.isUnbreakable();
        meta.setUnbreakable(true);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(meta);
        cancelBarrier = item;
        Bukkit.getLogger().info(Variables.logPrefix + "Cancel Barrier Created");
    }

    private static void createUnban() {
        Bukkit.getLogger().info(Variables.logPrefix + "Creating Unban Sign for GUI... ");
        ItemStack item = new ItemStack(Material.OAK_SIGN, 1);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Unban Sign Custom Properties... ");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§l§2Unban Player");
        List<String> lore = new ArrayList<>();
        lore.add("§o§fRight Click to Unban A Player");
        meta.setLore(lore);
        meta.isUnbreakable();
        meta.setUnbreakable(true);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(meta);
        unbanSign = item;
        Bukkit.getLogger().info(Variables.logPrefix + "Unban Sign Created");
    }
}
