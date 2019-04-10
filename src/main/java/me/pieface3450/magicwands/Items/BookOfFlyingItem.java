package me.pieface3450.magicwands.Items;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BookOfFlyingItem {
    public static ItemStack bofItem() {
        ItemStack bof = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemMeta bofMeta = bof.getItemMeta();
        bofMeta.setDisplayName(ChatColor.AQUA + "Book of Flying");
        bofMeta.setLore(Arrays.asList(ChatColor.AQUA + "Right-click" + ChatColor.DARK_PURPLE + " to enable flight", ChatColor.RED + "Left-click" + ChatColor.DARK_PURPLE + " to disable flight."));
        bof.setItemMeta(bofMeta);

        return bof;
    }
}
