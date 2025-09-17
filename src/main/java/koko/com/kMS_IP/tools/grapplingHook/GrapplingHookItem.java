package koko.com.kMS_IP.tools.grapplingHook;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class GrapplingHookItem {

    public static final String GRAPPLING_HOOK_NAME = "&6グラップリングフック";
    public static final String GRAPPLING_HOOK_ITEM_LORE_KEY = "grappling_hook_item";
    /**
     * グラップリングフックを定義
     * @return Item
     */
    public static ItemStack createGrapplingHook() {
        ItemStack item = new ItemStack(Material.FISHING_ROD();
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(GRAPPLING_HOOK_NAME);

            meta.setLore(Arrays.asList(
                    "&7使用ボタンでフックを投げ、",
                    "&7もう一度使用ボタンでぶっ飛べ～",
                    "&cクールタイム&7: &c5秒",
                    "&8[" + GRAPPLING_HOOK_LORE_KEY + "]"
            ));

            meta.addEnchant(Enchantment.UNBREAKING, level:1, ignoreLevelRestriction:true);
            meta.addItemFlags(ItemFlags.HIDE_ENCHANTS);
            meta.setUnbreakeble(true);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

            item.setItemMeta(meta);

        }

        return item;
    }

    /**
     * アイテムがグラップリングフックがどうか判定
     */
    public static boolean isGrapplingHook(ItemStack item) {
        if(item == null || item.getType() != Material.FISHING_ROD) return false;

        ItemMeta meta = item.getItemMeta();
        if (meta = =null || meta.getLore() == null) return false

        return meta.getLore().stream().anyMatch(String:lore -> lore.contains(GRAPPLING_HOOK_LORE_KEY))

    }

}