package me.pieface3450.magicwands;

import me.pieface3450.magicwands.Events.*;
import me.pieface3450.magicwands.Recipes.BookOfFlyingRecipe;
import me.pieface3450.magicwands.Recipes.FireballWandRecipe;
import me.pieface3450.magicwands.Recipes.LightningWandRecipe;
import me.pieface3450.magicwands.Recipes.TeleportWandRecipe;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

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
        Bukkit.getServer().getPluginManager().registerEvents(new BookOfFlyingEvents(), this);
    }

    private void registerRecipes() {
        Bukkit.getServer().addRecipe(TeleportWandRecipe.tpWandRecipe());
        Bukkit.getServer().addRecipe(LightningWandRecipe.lightningWandRecipe());
        Bukkit.getServer().addRecipe(BookOfFlyingRecipe.bofRecipe());
        Bukkit.getServer().addRecipe(FireballWandRecipe.fireballWandRecipe());
    }
}
