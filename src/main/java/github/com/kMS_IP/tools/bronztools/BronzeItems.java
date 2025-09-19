package com.example.bronzetools;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class BronzeItems {

    private static final int CUSTOM_MODEL_DATA = 2; // 全部共通で 2
    private static final int DURABILITY = 200; // 鉄より少し低い耐久

    private static ItemStack createTool(Material baseMaterial, String displayName) {
        ItemStack item = new ItemStack(baseMaterial);
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return item;

        meta.setDisplayName(displayName);
        meta.setCustomModelData(CUSTOM_MODEL_DATA);

        // 耐久調整
        if (meta instanceof Damageable dmgMeta) {
            int maxDurability = baseMaterial.getMaxDurability();
            int lost = maxDurability - DURABILITY;
            if (lost > 0) {
                dmgMeta.setDamage(lost);
            }
        }

        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createBronzeSword(JavaPlugin plugin) {
        return createTool(Material.IRON_SWORD, "§6ブロンズの剣");
    }

    public static ItemStack createBronzePickaxe(JavaPlugin plugin) {
        return createTool(Material.IRON_PICKAXE, "§6ブロンズのツルハシ");
    }

    public static ItemStack createBronzeAxe(JavaPlugin plugin) {
        return createTool(Material.IRON_AXE, "§6ブロンズの斧");
    }

    public static ItemStack createBronzeShovel(JavaPlugin plugin) {
        return createTool(Material.IRON_SHOVEL, "§6ブロンズのシャベル");
    }

    public static ItemStack createBronzeHoe(JavaPlugin plugin) {
        return createTool(Material.IRON_HOE, "§6ブロンズのクワ");
    }
}
