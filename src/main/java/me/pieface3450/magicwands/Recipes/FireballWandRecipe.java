package me.pieface3450.magicwands.Recipes;

import me.pieface3450.magicwands.Wands.FireballWandItem;
import org.bukkit.Material;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class FireballWandRecipe {
    public static Recipe fireballWandRecipe() {
        ShapedRecipe fireballWandRecipe = new ShapedRecipe(FireballWandItem.fireballWandItem());
        fireballWandRecipe.shape(
                "#L#",
                "#S#",
                "#S#");
        fireballWandRecipe.setIngredient('#', Material.AIR);
        fireballWandRecipe.setIngredient('L', Material.LAVA_BUCKET);
        fireballWandRecipe.setIngredient('S', Material.STICK);

        return fireballWandRecipe;
    }
}
