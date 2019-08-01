package me.pieface3450.magicwands.Recipes;

import me.pieface3450.magicwands.Items.BookOfFlyingItem;
import me.pieface3450.magicwands.Main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class BookOfFlyingRecipe {
    public static Recipe bofRecipe() {
        NamespacedKey key = new NamespacedKey(Main.getPlugin(Main.class), "book_of_flying");

        ShapedRecipe bofRecipe = new ShapedRecipe(key, BookOfFlyingItem.bofItem());
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
        bofRecipe.setIngredient('H', Material.DRAGON_HEAD);
        bofRecipe.setIngredient('E', Material.ELYTRA);

        return bofRecipe;
    }
}
