package me.pieface3450.magicwands.Wands;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LightningWandItem {
    public static ItemStack lightningWandItem() {
        ItemStack lightningWand = new ItemStack(Material.STICK, 1);
        ItemMeta lightningWandMeta = lightningWand.getItemMeta();
        lightningWandMeta.setDisplayName(ChatColor.AQUA + "Lightning Wand");
        lightningWandMeta.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Right-click to summon lightning where you are looking", "", ChatColor.DARK_RED + "Cost: 3 ♥", ChatColor.GREEN + "Max Range: 25 Blocks"));
        lightningWand.setItemMeta(lightningWandMeta);

        return lightningWand;
    }
}
