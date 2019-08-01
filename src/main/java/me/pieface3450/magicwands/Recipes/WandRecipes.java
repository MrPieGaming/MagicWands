package me.pieface3450.magicwands.Recipes;

import me.pieface3450.magicwands.Items.WandItems;
import me.pieface3450.magicwands.Main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class WandRecipes {

    public static Recipe fireballWandRecipe() {
        NamespacedKey key = new NamespacedKey(Main.getPlugin(Main.class), "fireball_wand");

        ShapedRecipe fireballWandRecipe = new ShapedRecipe(key, WandItems.fireballWandItem());
        fireballWandRecipe.shape(
                "L",
                "S",
                "S");

        fireballWandRecipe.setIngredient('L', Material.LAVA_BUCKET);
        fireballWandRecipe.setIngredient('S', Material.STICK);

        return fireballWandRecipe;
    }

    public static Recipe tpWandRecipe() {
        NamespacedKey key = new NamespacedKey(Main.getPlugin(Main.class), "teleport_wand");

        ShapedRecipe tpWandRecipe = new ShapedRecipe(key, WandItems.teleportWandItem());
        tpWandRecipe.shape(
                "E",
                "S",
                "S");
        tpWandRecipe.setIngredient('E', Material.ENDER_PEARL);
        tpWandRecipe.setIngredient('S', Material.STICK);

        return tpWandRecipe;
    }

    public static Recipe lightningWandRecipe() {
        NamespacedKey key = new NamespacedKey(Main.getPlugin(Main.class), "lightning_wand");

        ShapedRecipe lightningWandRecipe = new ShapedRecipe(key, WandItems.lightningWandItem());
        lightningWandRecipe.shape(
                "N",
                "S",
                "S");
        lightningWandRecipe.setIngredient('N', Material.NETHER_STAR);
        lightningWandRecipe.setIngredient('S', Material.STICK);

        return lightningWandRecipe;
    }
}
