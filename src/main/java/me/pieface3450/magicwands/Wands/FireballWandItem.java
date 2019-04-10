package me.pieface3450.magicwands.Wands;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FireballWandItem {
    public static ItemStack fireballWandItem() {
        ItemStack fireballWand = new ItemStack(Material.STICK);
        ItemMeta fbMeta = fireballWand.getItemMeta();
        fbMeta.setDisplayName(ChatColor.RED + "Fireball Wand");
        fbMeta.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Right-click to shoot a fireball in front of you", "", ChatColor.DARK_RED + "Cost: 1 ♥"));
        fireballWand.setItemMeta(fbMeta);

        return fireballWand;
    }
}
