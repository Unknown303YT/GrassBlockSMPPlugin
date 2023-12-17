package com.riverstone.unknown303.grassblocksmpplugin.items;

import com.riverstone.unknown303.grassblocksmpplugin.references.Variables;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class OnceoffItemsManager {
    public static ItemStack tntWand;
    public static int tntWandDurability = 5;
    public static void init() {
        createTNTWand();
    }

    private static void createTNTWand() {
        Bukkit.getLogger().info(Variables.logPrefix + "Creating TNT Wand... ");
        ItemStack item = new ItemStack(Material.STICK, 1);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying TNT Wand Custom Properties... ");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§l§TNT Wand");
        List<String> lore = new ArrayList<>();
        lore.add("§o§fRight Click to Use");
        lore.add("§o§6Note: Only Has 5 Uses!");
        lore.add("§o§fUses: " + tntWandDurability + "/5");
        meta.setLore(lore);
        meta.setUnbreakable(false);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying TNT Wand Enchantments... ");
        meta.addEnchant(Enchantment.DURABILITY, 255, false);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);

        ShapedRecipe tntWandRecipe = new ShapedRecipe(NamespacedKey.minecraft("tnt_wand"), item);
        tntWandRecipe.shape(" lt",
                            " sl",
                            "s  ");
        tntWandRecipe.setIngredient('l', Material.LAPIS_LAZULI);
        tntWandRecipe.setIngredient('s', Material.STICK);
        tntWandRecipe.setIngredient('t', Material.TNT);
        Bukkit.getServer().addRecipe(tntWandRecipe);

        tntWand = item;
        Bukkit.getLogger().info(Variables.logPrefix + "TNT Wand Created");
    }
}
