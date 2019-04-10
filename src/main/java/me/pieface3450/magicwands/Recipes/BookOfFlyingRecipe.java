package me.pieface3450.magicwands.Recipes;

import me.pieface3450.magicwands.Items.BookOfFlyingItem;
import org.bukkit.Material;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class BookOfFlyingRecipe {
    public static Recipe bofRecipe() {
        ShapedRecipe bofRecipe = new ShapedRecipe(BookOfFlyingItem.bofItem());
        bofRecipe.shape(
                "FHF",
                "LBI",
                "GED");
        bofRecipe.setIngredient('D', Material.DIAMOND_BOOTS);
        bofRecipe.setIngredient('L', Material.LEATHER_BOOTS);
        bofRecipe.setIngredient('I', Material.IRON_BOOTS);
        bofRecipe.setIngredient('G', Material.GOLDEN_BOOTS);
        bofRecipe.setIngredient('F', Material.FEATHER);
        bofRecipe.setIngredient('B', Material.BOOK);
        bofRecipe.setIngredient('H', Material.DRAGON_EGG);
        bofRecipe.setIngredient('E', Material.ELYTRA);

        return bofRecipe;
    }
}
