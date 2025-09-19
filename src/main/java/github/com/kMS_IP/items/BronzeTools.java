package github.com.kMS_IP.items;

import github.com.kMS_IP.utils.ItemLore;
import github.com.kMS_IP.utils.ItemRegister;
import github.com.kMS_IP.utils.RecipeRegistrar;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.attributeModifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;

import javax.lang.model.util.Elements;

public  class BronzeTools {

    private final Elements elements;
    private final RecipeRegistrar rr;

    public BronzeTools() {

        this.elements = new Elements();
        this.rr = new RecipeRegistrar();
        registerRecipes();

    }

    public static ItemStack bronzePickaxe() {

        ItemStack item = ItemRegister.createTool(Material.IRON_PICKAXE,"銅のツルハシ",
                ItemLore.Lore.BASIC_TOOL, 2,
                new String[]{

                        "&f銅で作られたツルハシ。",
                        "&f性能は鉄製品と同等だが、",
                        "&f若干軽量である。"

                }

        );
        ItemMeta meta = item.getItemMeta();

        /* ここに軽量になる処理 */
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,
                new AttributeModifier(java.util.UUID.randomUUID(), "bronze_speed", 0.05, AttributeModifier.Operation.MULTIPLY_SCALAR_1));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,
                new AttributeModifier(java.util.UUID.randomUUID(), "bronze_attack", 4.0, AttributeModifier.Operation.ADD_NUMBER));

        item.setItemMeta(meta);
        return item;

    }

    public static  ItemStack bronzeAxe() {

        ItemStack item = ItemRegister.createTool{Material.IRON_AXE, "銅の斧",

            ItemLore.Lore.BASIC_TOOL, 2,
            new String[]{

                    "&f銅で作られた斧。",
                    "&f性能は鉄製品と同等だが、",
                    "&f若干軽量である。"

            }

        };

        ItemMeta meta = item.getItemMeta();
        /* ここに軽量になる処理 */
        meta.addAttributeModifier(org.bukkit.attribute.Attribute.GENERIC_MOVEMENT_SPEED,
                new AttributeModifier(java.util.UUID.randomUUID(), "bronze_speed", 0.05, AttributeModifier.Operation.MULTIPLY_SCALAR_1));
        meta.addAttributeModifier(org.bukkit.attribute.Attribute.GENERIC_ATTACK_DAMAGE,
                new AttributeModifier(java.util.UUID.randomUUID(), "bronze_damage", 9.0, AttributeModifier.Operation.ADD_NUMBER));

        item.setItemMeta(meta);
        return item;

    }

    public static

}

