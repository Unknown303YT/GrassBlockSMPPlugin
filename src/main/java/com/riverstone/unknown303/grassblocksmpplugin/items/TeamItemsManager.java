package com.riverstone.unknown303.grassblocksmpplugin.items;

import com.riverstone.unknown303.grassblocksmpplugin.references.Variables;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TeamItemsManager {
    public static ItemStack leadersHat;
    public static ItemStack leadersShirt;
    public static ItemStack leadersPants;
    public static ItemStack leadersShoes;
    public static ItemStack lonersShield;

    public static void init() {
        createHat();
        createShirt();
        createPants();
        createShoes();
        createShield();
    }

    private static void createHat() {
        Bukkit.getLogger().info(Variables.logPrefix + "Creating LD Helmet... ");
        ItemStack item = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying LD Helmet Custom Properties... ");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§l§6Leader's Defence");
        List<String> lore = new ArrayList<>();
        lore.add("§o§fGrants Team Leaders 1");
        lore.add("§o§fExtra §4Heart §fPer Piece of Armor");
        meta.setLore(lore);
        meta.isUnbreakable();
        meta.setUnbreakable(true);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying LD Helmet Netherite Properties");
        Attribute armorAttribute = Attribute.GENERIC_ARMOR;
        AttributeModifier armorModifier = new AttributeModifier(UUID.randomUUID(), armorAttribute.name(), 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(armorAttribute, armorModifier);
        Attribute armorToughAttribute = Attribute.GENERIC_ARMOR_TOUGHNESS;
        AttributeModifier armorToughModifier = new AttributeModifier(UUID.randomUUID(), armorToughAttribute.name(), 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(armorToughAttribute, armorToughModifier);
        Attribute knockbackAttribute = Attribute.GENERIC_KNOCKBACK_RESISTANCE;
        AttributeModifier knockbackModifier = new AttributeModifier(UUID.randomUUID(), knockbackAttribute.name(), 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(knockbackAttribute, knockbackModifier);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Extra Heart Function...");
        Attribute attribute = Attribute.GENERIC_MAX_HEALTH;
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(),attribute.name(),2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(attribute,modifier);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying LD Helmet Enchantments... ");
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
        meta.addEnchant(Enchantment.WATER_WORKER, 1, false);
        meta.addEnchant(Enchantment.OXYGEN, 3, false);
        meta.addEnchant(Enchantment.THORNS, 3, false);
        meta.addEnchant(Enchantment.DURABILITY, 255, false);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(meta);
        leadersHat = item;
        Bukkit.getLogger().info(Variables.logPrefix + "LD Helmet Created");
    }

    private static void createShirt() {
        Bukkit.getLogger().info(Variables.logPrefix + "Creating LD Chestplate... ");
        ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying LD Chestplate Custom Properties... ");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§l§6Leader's Defence");
        List<String> lore = new ArrayList<>();
        lore.add("§o§fGrants Team Leaders 1");
        lore.add("§o§fExtra §4Heart §fPer Piece of Armor");
        meta.setLore(lore);
        meta.isUnbreakable();
        meta.setUnbreakable(true);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying LD Chestplate Netherite Properties");
        Attribute armorAttribute = Attribute.GENERIC_ARMOR;
        AttributeModifier armorModifier = new AttributeModifier(UUID.randomUUID(), armorAttribute.name(), 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(armorAttribute, armorModifier);
        Attribute armorToughAttribute = Attribute.GENERIC_ARMOR_TOUGHNESS;
        AttributeModifier armorToughModifier = new AttributeModifier(UUID.randomUUID(), armorToughAttribute.name(), 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(armorToughAttribute, armorToughModifier);
        Attribute knockbackAttribute = Attribute.GENERIC_KNOCKBACK_RESISTANCE;
        AttributeModifier knockbackModifier = new AttributeModifier(UUID.randomUUID(), knockbackAttribute.name(), 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(knockbackAttribute, knockbackModifier);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Extra Heart Function...");
        Attribute attribute = Attribute.GENERIC_MAX_HEALTH;
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(),attribute.name(),2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(attribute,modifier);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying LD Chestplate Enchantments... ");
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
        meta.addEnchant(Enchantment.DURABILITY, 255, false);
        meta.addEnchant(Enchantment.THORNS, 3, false);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(meta);
        leadersShirt = item;
        Bukkit.getLogger().info(Variables.logPrefix + "LD Chestplate Created");
    }

    private static void createPants() {
        Bukkit.getLogger().info(Variables.logPrefix + "Creating D Leggings... ");
        ItemStack item = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying LD Leggings Custom Properties... ");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§l§6Leader's Defence");
        List<String> lore = new ArrayList<>();
        lore.add("§o§fGrants Team Leaders 1");
        lore.add("§o§fExtra §l§4Heart §r§o§fPer Piece of Armor");
        meta.setLore(lore);
        meta.isUnbreakable();
        meta.setUnbreakable(true);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying LD Leggings Netherite Properties");
        Attribute armorAttribute = Attribute.GENERIC_ARMOR;
        AttributeModifier armorModifier = new AttributeModifier(UUID.randomUUID(), armorAttribute.name(), 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(armorAttribute, armorModifier);
        Attribute armorToughAttribute = Attribute.GENERIC_ARMOR_TOUGHNESS;
        AttributeModifier armorToughModifier = new AttributeModifier(UUID.randomUUID(), armorToughAttribute.name(), 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(armorToughAttribute, armorToughModifier);
        Attribute knockbackAttribute = Attribute.GENERIC_KNOCKBACK_RESISTANCE;
        AttributeModifier knockbackModifier = new AttributeModifier(UUID.randomUUID(), knockbackAttribute.name(), 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(knockbackAttribute, knockbackModifier);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Extra Heart Function...");
        Attribute attribute = Attribute.GENERIC_MAX_HEALTH;
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(),attribute.name(),2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(attribute,modifier);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying LD Leggings Enchantments... ");
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
        meta.addEnchant(Enchantment.THORNS, 3, false);
        meta.addEnchant(Enchantment.DURABILITY, 255, false);
        meta.addEnchant(Enchantment.SWIFT_SNEAK, 3, false);
        Bukkit.getLogger().info(Variables.logPrefix + "Hiding Enchantments... ");
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(meta);
        leadersPants = item;
        Bukkit.getLogger().info(Variables.logPrefix + "LD Leggings Created");
    }

    private static void createShoes() {
        Bukkit.getLogger().info(Variables.logPrefix + "Creating LD Boots... ");
        ItemStack item = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying LD Boots Custom Properties... ");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§l§6Leader's Defence");
        List<String> lore = new ArrayList<>();
        lore.add("§o§fGrants Team Leaders 1");
        lore.add("§o§fExtra §4Heart §fPer Piece of Armor");
        meta.setLore(lore);
        meta.isUnbreakable();
        meta.setUnbreakable(true);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying LD Boots Netherite Properties");
        Attribute armorAttribute = Attribute.GENERIC_ARMOR;
        AttributeModifier armorModifier = new AttributeModifier(UUID.randomUUID(), armorAttribute.name(), 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(armorAttribute, armorModifier);
        Attribute armorToughAttribute = Attribute.GENERIC_ARMOR_TOUGHNESS;
        AttributeModifier armorToughModifier = new AttributeModifier(UUID.randomUUID(), armorToughAttribute.name(), 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(armorToughAttribute, armorToughModifier);
        Attribute knockbackAttribute = Attribute.GENERIC_KNOCKBACK_RESISTANCE;
        AttributeModifier knockbackModifier = new AttributeModifier(UUID.randomUUID(), knockbackAttribute.name(), 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(knockbackAttribute, knockbackModifier);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Extra Heart Function...");
        Attribute attribute = Attribute.GENERIC_MAX_HEALTH;
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(),attribute.name(),2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(attribute,modifier);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying LD Boots Enchantments... ");
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
        meta.addEnchant(Enchantment.PROTECTION_FALL, 4, false);
        meta.addEnchant(Enchantment.THORNS, 3, false);
        meta.addEnchant(Enchantment.DURABILITY, 255, false);
        meta.addEnchant(Enchantment.DEPTH_STRIDER, 3, false);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(meta);
        leadersShoes = item;
        Bukkit.getLogger().info(Variables.logPrefix + "LD Boots Created");
    }

    private static void createShield() {
        Bukkit.getLogger().info(Variables.logPrefix + "Creating Loner's Shield... ");
        ItemStack item = new ItemStack(Material.SHIELD, 1);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Loner's Shield Custom Properties... ");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§l§6Loner's Shield");
        List<String> lore = new ArrayList<>();
        lore.add("§o§fGrants Wearer Saturation");
        meta.setLore(lore);
        meta.isUnbreakable();
        meta.setUnbreakable(true);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Loner's Shield Enchantments... ");
        meta.addEnchant(Enchantment.DURABILITY, 255, false);
        Bukkit.getLogger().info(Variables.logPrefix + "Applying Item Flags... ");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(meta);
        lonersShield = item;
        Bukkit.getLogger().info(Variables.logPrefix + "Loner's Shield Created");
    }
}