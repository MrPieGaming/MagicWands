package me.pieface3450.magicwands.Recipes;

import me.pieface3450.magicwands.Wands.TeleportWandItem;
import org.bukkit.Material;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class TeleportWandRecipe {
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
}
