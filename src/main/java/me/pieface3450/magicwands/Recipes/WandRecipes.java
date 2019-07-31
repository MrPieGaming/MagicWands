package me.pieface3450.magicwands.Recipes;

import me.pieface3450.magicwands.Main;
import me.pieface3450.magicwands.Wands.FireballWandItem;
import me.pieface3450.magicwands.Wands.LightningWandItem;
import me.pieface3450.magicwands.Wands.TeleportWandItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class WandRecipes {

    public static Recipe fireballWandRecipe() {
        NamespacedKey key = new NamespacedKey(Main.getPlugin(Main.class), "fireball_wand");

        ShapedRecipe fireballWandRecipe = new ShapedRecipe(key, FireballWandItem.fireballWandItem());
        fireballWandRecipe.shape(
                " L ",
                " S ",
                " S ");
        fireballWandRecipe.setIngredient('L', Material.LAVA_BUCKET);
        fireballWandRecipe.setIngredient('S', Material.STICK);

        return fireballWandRecipe;
    }

    public static Recipe tpWandRecipe() {
        ShapedRecipe tpWandRecipe = new ShapedRecipe(TeleportWandItem.teleportWandItem());
        tpWandRecipe.shape("#E#",
                "#S#",
                "#S#");
        tpWandRecipe.setIngredient('#', Material.AIR);
        tpWandRecipe.setIngredient('E', Material.ENDER_PEARL);
        tpWandRecipe.setIngredient('S', Material.STICK);

        return tpWandRecipe;
    }

    public static Recipe lightningWandRecipe() {
        ShapedRecipe lightningWandRecipe = new ShapedRecipe(LightningWandItem.lightningWandItem());
        lightningWandRecipe.shape("#N#",
                "#S#",
                "#S#");
        lightningWandRecipe.setIngredient('#', Material.AIR);
        lightningWandRecipe.setIngredient('N', Material.NETHER_STAR);
        lightningWandRecipe.setIngredient('S', Material.STICK);

        return lightningWandRecipe;
    }
}
