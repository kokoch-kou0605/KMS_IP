package github.com.kMS_IP.bronztools;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class BronzeRecipes {
    public static void registerRecipes(JavaPlugin plugin) {

        // 剣
        {
            ItemStack result = BronzeItems.createBronzeSword(plugin);
            NamespacedKey key = new NamespacedKey(plugin, "bronze_sword");
            ShapedRecipe recipe = new ShapedRecipe(key, result);
            recipe.shape("C", "C", "S");
            recipe.setIngredient('C', Material.COPPER_INGOT);
            recipe.setIngredient('S', Material.STICK);
            Bukkit.addRecipe(recipe);
        }

        // ツルハシ
        {
            ItemStack result = BronzeItems.createBronzePickaxe(plugin);
            NamespacedKey key = new NamespacedKey(plugin, "bronze_pickaxe");
            ShapedRecipe recipe = new ShapedRecipe(key, result);
            recipe.shape("CCC", " S ", " S ");
            recipe.setIngredient('C', Material.COPPER_INGOT);
            recipe.setIngredient('S', Material.STICK);
            Bukkit.addRecipe(recipe);
        }

        // 斧
        {
            ItemStack result = BronzeItems.createBronzeAxe(plugin);
            NamespacedKey key = new NamespacedKey(plugin, "bronze_axe");
            ShapedRecipe recipe = new ShapedRecipe(key, result);
            recipe.shape("CC ", "CS ", " S ");
            recipe.setIngredient('C', Material.COPPER_INGOT);
            recipe.setIngredient('S', Material.STICK);
            Bukkit.addRecipe(recipe);
        }

        // シャベル
        {
            ItemStack result = BronzeItems.createBronzeShovel(plugin);
            NamespacedKey key = new NamespacedKey(plugin, "bronze_shovel");
            ShapedRecipe recipe = new ShapedRecipe(key, result);
            recipe.shape(" C ", " S ", " S ");
            recipe.setIngredient('C', Material.COPPER_INGOT);
            recipe.setIngredient('S', Material.STICK);
            Bukkit.addRecipe(recipe);
        }

        // クワ
        {
            ItemStack result = BronzeItems.createBronzeHoe(plugin);
            NamespacedKey key = new NamespacedKey(plugin, "bronze_hoe");
            ShapedRecipe recipe = new ShapedRecipe(key, result);
            recipe.shape("CC ", " S ", " S ");
            recipe.setIngredient('C', Material.COPPER_INGOT);
            recipe.setIngredient('S', Material.STICK);
            Bukkit.addRecipe(recipe);
        }
    }
}
