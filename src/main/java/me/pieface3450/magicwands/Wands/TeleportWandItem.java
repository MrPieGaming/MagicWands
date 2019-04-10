package me.pieface3450.magicwands.Wands;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeleportWandItem {
    public static ItemStack teleportWandItem() {
        ItemStack tpWand = new ItemStack(Material.STICK, 1);
        ItemMeta tpWandMeta = tpWand.getItemMeta();
        tpWandMeta.setDisplayName(ChatColor.DARK_AQUA + "Teleport Wand");
        tpWandMeta.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Right-click to teleport to the block you are looking at", "", ChatColor.DARK_RED + "Cost: 2 ♥", ChatColor.GREEN + "Max Range: 50 Blocks"));
        tpWand.setItemMeta(tpWandMeta);

        return tpWand;
    }
}
