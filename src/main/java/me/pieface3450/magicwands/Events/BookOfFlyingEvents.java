package me.pieface3450.magicwands.Events;

import me.pieface3450.magicwands.Items.BookOfFlyingItem;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;

public class BookOfFlyingEvents implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        ItemStack bof = new ItemStack(BookOfFlyingItem.bofItem());
        if ((event.getItemDrop().getItemStack().equals(bof)) && (event.getPlayer().getGameMode() != GameMode.CREATIVE) &&
                (event.getPlayer().getAllowFlight())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.DARK_RED + "Disable flight before dropping the book.");
        }
    }

    @EventHandler
    public void onShiftClick(InventoryClickEvent event) {
        if (event.getSlot() == -1 || event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) return;

        if (event.getClick().isShiftClick()) {
            Inventory clicked = event.getClickedInventory();
            if (clicked == event.getWhoClicked().getInventory()) {
                ItemStack clickedOn = event.getCurrentItem();

                if (clickedOn != null && clickedOn.equals(BookOfFlyingItem.bofItem())) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getSlot() == -1 || event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) return;

        Inventory clicked = event.getClickedInventory();
        if (clicked != event.getWhoClicked().getInventory()) {
            ItemStack onCursor = event.getCursor();

            if (onCursor != null && onCursor.equals(BookOfFlyingItem.bofItem())) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDrag(InventoryDragEvent event) {
        if (event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) return;
        ItemStack dragged = event.getOldCursor();

        if (dragged.equals(BookOfFlyingItem.bofItem())) {
            int inventorySize = event.getInventory().getSize();

            for (int i : event.getRawSlots()) {
                if (i < inventorySize) {
                    event.setCancelled(true);
                    break;
                }
            }
        }
    }

    @EventHandler
    public void onBookRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack bof = new ItemStack(BookOfFlyingItem.bofItem());
        if (player.getInventory().getItemInMainHand().equals(bof)) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR) {
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.AQUA + "Flight has been enabled. Double-tap " + ChatColor.BLUE + "'Space'" + ChatColor.AQUA + " to enable/disable flight.");
            }
            if (event.getAction() == Action.LEFT_CLICK_AIR) {
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.RED + "Flight has been disabled.");
            }
        }
    }
}
