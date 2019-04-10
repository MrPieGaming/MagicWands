package me.pieface3450.magicwands.Recipes;

import me.pieface3450.magicwands.Wands.LightningWandItem;
import org.bukkit.Material;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class LightningWandRecipe {
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
