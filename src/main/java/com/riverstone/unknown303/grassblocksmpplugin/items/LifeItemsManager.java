package com.riverstone.unknown303.grassblocksmpplugin.items;

import com.riverstone.unknown303.grassblocksmpplugin.multiclassreferencefiles.Variables;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
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
    public static ItemStack blankPane;

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

        ShapedRecipe fragRecipe = new ShapedRecipe(NamespacedKey.minecraft("life_fragment"), item);
        fragRecipe.shape("dwd",
                         "ImI",
                         "GtG");
        fragRecipe.setIngredient('d', Material.DIAMOND);
        fragRecipe.setIngredient('w', Material.NETHER_WART);
        fragRecipe.setIngredient('I', Material.IRON_BLOCK);
        fragRecipe.setIngredient('m', Material.GLISTERING_MELON_SLICE);
        fragRecipe.setIngredient('G', Material.GOLD_BLOCK);
        fragRecipe.setIngredient('t', Material.TOTEM_OF_UNDYING);
        Bukkit.getServer().addRecipe(fragRecipe);

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
        ShapedRecipe shardRecipe = new ShapedRecipe(NamespacedKey.minecraft("life_shard"), item);
        shardRecipe.shape("fbf",
                          "DmD",
                          "ftf");
        shardRecipe.setIngredient('f', new RecipeChoice.ExactChoice(lifeFragment));
        shardRecipe.setIngredient('b', Material.BLUE_ORCHID);
        shardRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        shardRecipe.setIngredient('m', Material.MUSHROOM_STEW);
        shardRecipe.setIngredient('t', Material.TOTEM_OF_UNDYING);
        Bukkit.getServer().addRecipe(shardRecipe);

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

        ShapedRecipe lifeRecipe = new ShapedRecipe(NamespacedKey.minecraft("life"), item);
        lifeRecipe.shape("ses",
                         "npn",
                         "sts");
        lifeRecipe.setIngredient('s', new RecipeChoice.ExactChoice(lifeShard));
        lifeRecipe.setIngredient('e', Material.ELYTRA);
        lifeRecipe.setIngredient('n', Material.NETHERITE_INGOT);
        lifeRecipe.setIngredient('p', Material.GOLDEN_APPLE);
        lifeRecipe.setIngredient('t', Material.TOTEM_OF_UNDYING);
        Bukkit.getServer().addRecipe(lifeRecipe);

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

        ShapedRecipe rbRecipe = new ShapedRecipe(NamespacedKey.minecraft("revive_beacon"), item);
        rbRecipe.shape("lgl",
                       "lsl",
                       "ooo");
        rbRecipe.setIngredient('l', new RecipeChoice.ExactChoice(life));
        rbRecipe.setIngredient('g', Material.GLASS);
        rbRecipe.setIngredient('s', Material.NETHER_STAR);
        rbRecipe.setIngredient('o', Material.OBSIDIAN);
        Bukkit.getServer().addRecipe(rbRecipe);
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
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

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
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);
        unbanSign = item;
        Bukkit.getLogger().info(Variables.logPrefix + "Unban Sign Created");
    }

    private static void createBlank() {
        Bukkit.getLogger().info(Variables.logPrefix + "Creating Blank Stained Glass for GUI... ");
        ItemStack item = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Blank Stained Glass Custom Properties... ");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("");
        List<String> lore = new ArrayList<>();
        lore.add("");
        meta.setLore(lore);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);
        blankPane = item;
        Bukkit.getLogger().info(Variables.logPrefix + "Blank Stained Glass Created");
    }
}
