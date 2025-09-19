package com.example.bronzetools;

import org.bukkit.plugin.java.JavaPlugin;

public class BronzeToolsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("BronzeToolsPlugin enabled!");

        // レシピ登録
        BronzeRecipes.registerRecipes(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("BronzeToolsPlugin disabled!");
    }
}
