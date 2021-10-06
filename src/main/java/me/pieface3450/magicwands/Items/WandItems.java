package me.pieface3450.magicwands.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class WandItems {
    public static ItemStack fireballWandItem() {
        ItemStack fireballWand = new ItemStack(Material.STICK);
        ItemMeta fbMeta = fireballWand.getItemMeta();

        if (fbMeta != null) {
            fbMeta.setDisplayName(ChatColor.RED + "Fireball Wand");
            fbMeta.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Right-click to shoot a fireball in front of you", "", ChatColor.DARK_RED + "Cost: 1 ♥"));
            fireballWand.setItemMeta(fbMeta);
        }

        return fireballWand;
    }

    public static ItemStack lightningWandItem() {
        ItemStack lightningWand = new ItemStack(Material.STICK, 1);
        ItemMeta lightningWandMeta = lightningWand.getItemMeta();

        if (lightningWandMeta != null) {
            lightningWandMeta.setDisplayName(ChatColor.AQUA + "Lightning Wand");
            lightningWandMeta.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Right-click to summon lightning where you are looking", "", ChatColor.DARK_RED + "Cost: 3 ♥", ChatColor.GREEN + "Max Range: 25 Blocks"));
            lightningWand.setItemMeta(lightningWandMeta);
        }

        return lightningWand;
    }

    public static ItemStack teleportWandItem() {
        ItemStack tpWand = new ItemStack(Material.STICK, 1);
        ItemMeta tpWandMeta = tpWand.getItemMeta();

        if (tpWandMeta != null) {
            tpWandMeta.setDisplayName(ChatColor.DARK_AQUA + "Teleport Wand");
            tpWandMeta.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Right-click to teleport to the block you are looking at", "", ChatColor.DARK_RED + "Cost: 2 ♥", ChatColor.GREEN + "Max Range: 50 Blocks"));
            tpWand.setItemMeta(tpWandMeta);
        }

        return tpWand;
    }
}
