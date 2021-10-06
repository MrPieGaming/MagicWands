package me.pieface3450.magicwands;

import me.pieface3450.magicwands.Events.*;
import me.pieface3450.magicwands.Recipes.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        getLogger().info("Magic Wands v" + getDescription().getVersion() + " enabled");
        registerEvents();
        registerRecipes();
    }

    public void onDisable() {
        getLogger().info("Magic Wands v" + getDescription().getVersion() + " disabled");
    }

    private void registerEvents() {
        Bukkit.getServer().getPluginManager().registerEvents(new WandEvents(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new BookOfFlyingEvents(this), this);
    }

    private void registerRecipes() {
        Bukkit.getServer().addRecipe(WandRecipes.tpWandRecipe());
        Bukkit.getServer().addRecipe(WandRecipes.lightningWandRecipe());
        Bukkit.getServer().addRecipe(WandRecipes.fireballWandRecipe());
        Bukkit.getServer().addRecipe(BookOfFlyingRecipe.bofRecipe());
    }
}
