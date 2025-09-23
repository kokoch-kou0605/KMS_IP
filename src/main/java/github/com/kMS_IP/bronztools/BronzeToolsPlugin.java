package github.com.kMS_IP.bronztools;

import org.bukkit.plugin.java.JavaPlugin;

public class BronzeToolsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("BronzeToolsPlugin enabled!");

        // レシピ登録
        BronzeRecipes.registerRecipes(this);

        // 金床での修理リスナー登録
        getServer().getPluginManager().registerEvents(new BronzeAnvilListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("BronzeToolsPlugin disabled!");
    }
}
