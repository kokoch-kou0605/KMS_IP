package com.example.bronzetools;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BronzeAnvilListener implements Listener {

    @EventHandler
    public void onAnvilPrepare(PrepareAnvilEvent event) {
        AnvilInventory inv = event.getInventory();
        ItemStack left = inv.getItem(0);   // 左スロット
        ItemStack right = inv.getItem(1);  // 右スロット

        if (left == null || right == null) return;

        // 左がブロンズツールかどうか（CustomModelData=2 & 名前に"ブロンズ"を含む）
        if (!isBronzeTool(left)) return;

        // 右が銅インゴットかどうか
        if (right.getType() != Material.COPPER_INGOT) return;

        // 修理したアイテムを作成
        ItemStack repaired = left.clone();
        if (repaired.getItemMeta() instanceof org.bukkit.inventory.meta.Damageable dmg) {
            dmg.setDamage(0); // 完全修理
            repaired.setItemMeta((ItemMeta) dmg);
        }

        // 修理結果を設定
        event.setResult(repaired);
    }

    private boolean isBronzeTool(ItemStack item) {
        if (!item.hasItemMeta()) return false;
        ItemMeta meta = item.getItemMeta();
        if (meta == null || meta.getCustomModelData() != 2) return false;
        return meta.hasDisplayName() && meta.getDisplayName().contains("ブロンズ");
    }
}
